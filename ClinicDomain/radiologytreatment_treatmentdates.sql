--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."radiologytreatment_treatmentdates" DROP CONSTRAINT "fk_radiologytreatment_treatmentdates_radiologytreatment_id";

DROP TABLE "public"."radiologytreatment_treatmentdates";

CREATE TABLE "public"."radiologytreatment_treatmentdates" (
		"radiologytreatment_id" INT8,
		"treatmentdates" DATE
	);

ALTER TABLE "public"."radiologytreatment_treatmentdates" ADD CONSTRAINT "fk_radiologytreatment_treatmentdates_radiologytreatment_id" FOREIGN KEY ("radiologytreatment_id")
	REFERENCES "public"."treatment" ("id");

