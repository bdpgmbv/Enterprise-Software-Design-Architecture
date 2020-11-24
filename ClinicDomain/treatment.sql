--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."treatment" DROP CONSTRAINT "fk_treatment_patient_id";

ALTER TABLE "public"."treatment" DROP CONSTRAINT "fk_treatment_provider_id";

ALTER TABLE "public"."treatment" DROP CONSTRAINT "treatment_pkey";

DROP INDEX "public"."treatment_pkey";

DROP TABLE "public"."treatment";

CREATE TABLE "public"."treatment" (
		"id" INT8 NOT NULL,
		"treatment_type_disc" VARCHAR(31),
		"diagnosis" VARCHAR(255),
		"patient_id" INT8 NOT NULL,
		"provider_id" INT8 NOT NULL
	);

CREATE UNIQUE INDEX "public"."treatment_pkey" ON "public"."treatment" ("id" ASC);

ALTER TABLE "public"."treatment" ADD CONSTRAINT "treatment_pkey" PRIMARY KEY ("id");

ALTER TABLE "public"."treatment" ADD CONSTRAINT "fk_treatment_patient_id" FOREIGN KEY ("patient_id")
	REFERENCES "public"."patient" ("id");

ALTER TABLE "public"."treatment" ADD CONSTRAINT "fk_treatment_provider_id" FOREIGN KEY ("provider_id")
	REFERENCES "public"."provider" ("id");

