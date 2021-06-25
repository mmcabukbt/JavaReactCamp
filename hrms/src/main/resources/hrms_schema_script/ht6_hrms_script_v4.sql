-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.

-- Araştırıp uygun bulduğum REGEX email value check constraint değerleri:
-- ^[\w!#$%&''*+/=?`{|}~^-]+(?:\.[\w!#$%&''*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,6}$			// Benim Tercihim
-- >>> IP Adresli emaile doğru validasyon + %99.9 Doğru validasyon (İddiaları bu) https://emailregex.com;
-- (?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
-- ^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$			// OWASP Validation Regex Repository
-- ^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$			// HTML input-email (eski)
-- ^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$   //HTML5-input(yeni) Ancak süzgeç gibi

BEGIN;

CREATE DOMAIN public.checked_email
    AS character varying(100)
    NOT NULL;
ALTER DOMAIN public.checked_email
    ADD CONSTRAINT email_format CHECK (VALUE ~ '^[\w!#$%&''*+/=?`{|}~^-]+(?:\.[\w!#$%&''*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,6}$');

ALTER DOMAIN public.checked_email OWNER TO postgres;
COMMENT ON DOMAIN public.checked_email
    IS 'email format checkini otomatik yapar';

CREATE TABLE IF NOT EXISTS public."claims"
(
    id smallserial PRIMARY KEY,
    name character varying(50) UNIQUE NOT NULL
);
COMMENT ON TABLE public."claims"
    IS 'Tüm Usersin alabileceği rol/claim/haklar';

CREATE TABLE IF NOT EXISTS public."users"
(
    id bigserial PRIMARY KEY,
    "email" checked_email UNIQUE NOT NULL, --PRIMARY KEY ile aynı!
    "password_hash" bytea NOT NULL,
	"password_salt" bytea NOT NULL,	
	"active" boolean DEFAULT false NOT NULL
);
COMMENT ON TABLE public."users"
    IS 'Tüm kullanıcıların temel sınıfı';

CREATE TABLE IF NOT EXISTS public."user_claims"
(
	"user_id" bigint NOT NULL REFERENCES public."users" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    "claim_id" smallint NOT NULL DEFAULT 30 REFERENCES public."claims" (id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE
);
COMMENT ON TABLE public."user_claims"
    IS 'Tüm Usersin aldığı rol/claim/haklar';

CREATE TABLE IF NOT EXISTS public."industries"
(
    id smallserial PRIMARY KEY,
    name character varying(50) UNIQUE NOT NULL
);
COMMENT ON TABLE public."industries"
    IS 'Ana Sektörler / Endüstriler ';

CREATE TABLE IF NOT EXISTS public."sub_job_categories"
(
    id smallserial PRIMARY KEY,
    name character varying(50) UNIQUE NOT NULL
);
COMMENT ON TABLE public."sub_job_categories"
    IS 'Alt Sınıf İş Kategorileri';

CREATE TABLE IF NOT EXISTS public."jobs"
(
    id smallserial PRIMARY KEY,
	"industry_id" smallint REFERENCES public."industries" (id) NOT NULL,
    "sub_job_category_id" smallint REFERENCES public."sub_job_categories" (id) NOT NULL,
    "title" character varying(50) UNIQUE NOT NULL
);
COMMENT ON TABLE public."sub_job_categories"
    IS 'Genel iş pozisyonları';

CREATE TABLE IF NOT EXISTS public."persons"
(
    "user_id" bigint PRIMARY KEY REFERENCES public."users" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    "tckno" character(11) UNIQUE NOT NULL,
    "first_name" character varying(50) NOT NULL,
    "last_name" character varying(50) NOT NULL,
    "year_of_birth" smallint NOT NULL
);
COMMENT ON TABLE public."persons"
    IS 'Tüm Gerçek Kişiler için temel sınıf';

CREATE TABLE IF NOT EXISTS public."staffs"
(
    "user_id" bigint PRIMARY KEY REFERENCES public."persons" ("user_id") MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    "job_id" smallint REFERENCES public."jobs" (id) NOT NULL,
	"salary" double precision NOT NULL DEFAULT 0
);
COMMENT ON TABLE public."staffs"
    IS 'Sistem Personeli';

CREATE TABLE IF NOT EXISTS public."jobseekers"
(
    "user_id" bigint PRIMARY KEY REFERENCES public."persons" ("user_id") MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    "jobseek_status" boolean NOT NULL DEFAULT true
);
COMMENT ON TABLE public."jobseekers"
    IS 'İş Arayanlar';

CREATE TABLE IF NOT EXISTS public."corporates"
(
    "user_id" bigint PRIMARY KEY REFERENCES public."users" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    name character varying(100) NOT NULL,
    "website" character varying(100) NOT NULL,
    "phone" character varying(12) NOT NULL
);
COMMENT ON TABLE public."corporates"
    IS 'Tüm Tüzel Kişilik/Kurumlar için temel sınıf';

CREATE TABLE IF NOT EXISTS public."employers"
(
    "user_id" bigint PRIMARY KEY REFERENCES public."users" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
	"industry_id" smallint NOT NULL REFERENCES public."industries" (id)
);
COMMENT ON TABLE public."employers"
    IS 'İş Verenler / Şirketler';


CREATE TABLE IF NOT EXISTS public."unconfirmed_users"
(
    "user_id" integer PRIMARY KEY REFERENCES public."users" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
	"email" checked_email NOT NULL, 
    "user_uuid" uuid NOT NULL
);
COMMENT ON TABLE public."unconfirmed_users"
    IS 'Henüz email - ya da manuel onay almamış kullanıcıların geçici deposu';
--- - - - - - - - - - -- - - -  -- - - -  - - - - - - -

CREATE TABLE IF NOT EXISTS public."cities"
(
    id smallserial PRIMARY KEY,
    name character varying(25) UNIQUE NOT NULL
);
COMMENT ON TABLE public."cities"
    IS 'Şehirler';

--- - - - - - - - - - -- - - -  -- - - -  - - - - - - -

CREATE TABLE IF NOT EXISTS public.job_posts
(
    id bigserial PRIMARY KEY,
	user_id bigint NOT NULL REFERENCES public.users (id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
    max_salary double precision NOT NULL,
    min_salary double precision NOT NULL,
    posting_date timestamp without time zone NOT NULL DEFAULT now(),
    closing_date date NOT NULL,
    open_positions smallint NOT NULL,
	city_id smallint NOT NULL REFERENCES public.cities (id) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT,
    job_id smallint NOT NULL REFERENCES public.jobs (id) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT,
	active boolean NOT NULL,
	description character varying(255) NOT NULL,
	UNIQUE (user_id, job_id, description)
);
COMMENT ON TABLE public.job_posts
    IS 'İş İlanları';

--- - - - - - - - - - -- - - -  -- - - -  - - - - - - - - - - - - - - - - - - -
--resume detayları user_id ile SADECE TEK CV(RESUME) olduğundan User a bağlandı / Aslında Resume_id ye bağlanmalı daha sonra çoklu CV ler için
-- - - - - - - - - - -- - - -  -- - - -  - - - - - - - - - - - - - - - - - - -
CREATE TABLE IF NOT EXISTS public.js_resumes
(
    id bigserial PRIMARY KEY,
	user_id bigint NOT NULL REFERENCES public.users (id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
    image character varying(255),
	presentation character varying(255),
	link_github character varying(255),
	link_linkedin character varying(255)
);
COMMENT ON TABLE public.js_resumes
    IS 'JobSeeker Özgeçmişleri';

CREATE TABLE IF NOT EXISTS public.js_educations
(
	id bigserial PRIMARY KEY,
    resume_id bigint NOT NULL REFERENCES public.js_resumes (id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
    school_name character varying(75) NOT NULL,
    branch character varying(75) NOT NULL,
    starting_year smallint NOT NULL,
    finishing_year smallint,
	UNIQUE (resume_id, school_name, starting_year)
);
COMMENT ON TABLE public.js_educations
    IS 'Eğitim geçmişleri';
CREATE INDEX js_educations_idx ON public.js_educations USING btree
    (starting_year DESC NULLS FIRST)    TABLESPACE pg_default;
	
CREATE TABLE IF NOT EXISTS public.js_experiences
(
	id bigserial PRIMARY KEY,
    resume_id bigint NOT NULL REFERENCES public.js_resumes (id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
    employer_name character varying(75) NOT NULL,
    department character varying(75) NOT NULL,
    starting_year smallint NOT NULL,
    finishing_year smallint,
	UNIQUE (resume_id, employer_name, starting_year)
);
COMMENT ON TABLE public.js_experiences
    IS 'Çalışma geçmişleri';
CREATE INDEX js_experiences_idx ON public.js_experiences USING btree
    (starting_year DESC NULLS FIRST)    TABLESPACE pg_default;
--- - - - - - - - - - -- - - -  -- - - -  - - - - - - -

CREATE TABLE IF NOT EXISTS public.knowledge_levels
(
    id smallserial PRIMARY KEY,
    name character varying(50) NOT NULL
);
INSERT INTO knowledge_levels (id, name) VALUES  (1, 'A1 - Beginner / No Proficiency'), (2, 'A2 - Elementary Proficiency'), (3, 'B1 - Intermediate / Limited Proficiency'),
	(4, 'B2 - Upper Intermediate / Professional Proficiency'), (5, 'C1 - Advanced / Full Professional Proficiency'), (6, 'C2 - Mastery / Native / Bilingual Proficiency');
COMMENT ON TABLE public.knowledge_levels
    IS 'Yabancı Dil / Programlama Dili / Teknoloji Yeterlilik / Bilgi Seviyeleri';
	
CREATE TABLE IF NOT EXISTS public.foreign_languages
(
   id smallserial PRIMARY KEY,
   name character varying(40) UNIQUE NOT NULL
);
COMMENT ON TABLE public.foreign_languages
    IS 'Yabancı Diller Listesi';	

CREATE TABLE IF NOT EXISTS public."js_foreign_lang_knowledges"
(
	id bigserial PRIMARY KEY,
	"resume_id" bigint NOT NULL REFERENCES public."js_resumes" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    "f_lang_id" smallint NOT NULL DEFAULT 21 REFERENCES public."foreign_languages" (id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	"know_lvl_id" smallint NOT NULL DEFAULT 1 REFERENCES public."knowledge_levels" (id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	UNIQUE (resume_id, f_lang_id)
);
COMMENT ON TABLE public."js_foreign_lang_knowledges"
    IS 'JobSeeker Resume(Özgeçmiş) için bildiği Yabancı diller ve sevileri';
--- - - - - - - - - - -- - - -  -- - - -  - - - - - - -
CREATE TABLE IF NOT EXISTS public.programming_techs
(
   id smallserial PRIMARY KEY,
   name character varying(60) UNIQUE NOT NULL
);
COMMENT ON TABLE public.programming_techs
    IS 'Programlama Dili / Teknoloji Listesi';

CREATE TABLE IF NOT EXISTS public."js_prog_tech_knowledges"
(
	id bigserial PRIMARY KEY,
	"resume_id" bigint NOT NULL REFERENCES public."js_resumes" (id) MATCH FULL ON DELETE CASCADE ON UPDATE CASCADE,
    "prg_tech_id" smallint NOT NULL DEFAULT 121 REFERENCES public."programming_techs" (id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	"know_lvl_id" smallint NOT NULL DEFAULT 1 REFERENCES public."knowledge_levels" (id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	UNIQUE (resume_id, prg_tech_id)
);
COMMENT ON TABLE public."js_prog_tech_knowledges"
    IS 'JobSeeker Resume(Özgeçmiş) için bildiği Programlama dilleri/Teknolojiler ve sevileri';
--- - - - - - - - - - -- - - -  -- - - -  - - - - - - -

	
	
END;