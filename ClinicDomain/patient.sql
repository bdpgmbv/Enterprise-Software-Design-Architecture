--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."patient" DROP CONSTRAINT "patient_pkey";

DROP INDEX "public"."patient_pkey";

DROP TABLE "public"."patient";

CREATE TABLE "public"."patient" (
		"id" INT8 NOT NULL,
		"name" VARCHAR(255),
		"patientid" INT8
	);

CREATE UNIQUE INDEX "public"."patient_pkey" ON "public"."patient" ("id" ASC);

ALTER TABLE "public"."patient" ADD CONSTRAINT "patient_pkey" PRIMARY KEY ("id");

