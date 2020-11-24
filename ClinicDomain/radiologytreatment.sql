--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."radiologytreatment" DROP CONSTRAINT "fk_radiologytreatment_id";

ALTER TABLE "public"."radiologytreatment" DROP CONSTRAINT "radiologytreatment_pkey";

DROP INDEX "public"."radiologytreatment_pkey";

DROP TABLE "public"."radiologytreatment";

CREATE TABLE "public"."radiologytreatment" (
		"id" INT8 NOT NULL
	);

CREATE UNIQUE INDEX "public"."radiologytreatment_pkey" ON "public"."radiologytreatment" ("id" ASC);

ALTER TABLE "public"."radiologytreatment" ADD CONSTRAINT "radiologytreatment_pkey" PRIMARY KEY ("id");

ALTER TABLE "public"."radiologytreatment" ADD CONSTRAINT "fk_radiologytreatment_id" FOREIGN KEY ("id")
	REFERENCES "public"."treatment" ("id");

