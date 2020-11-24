--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."surgerytreatment" DROP CONSTRAINT "fk_surgerytreatment_id";

ALTER TABLE "public"."surgerytreatment" DROP CONSTRAINT "surgerytreatment_pkey";

DROP INDEX "public"."surgerytreatment_pkey";

DROP TABLE "public"."surgerytreatment";

CREATE TABLE "public"."surgerytreatment" (
		"id" INT8 NOT NULL,
		"surgerydate" DATE
	);

CREATE UNIQUE INDEX "public"."surgerytreatment_pkey" ON "public"."surgerytreatment" ("id" ASC);

ALTER TABLE "public"."surgerytreatment" ADD CONSTRAINT "surgerytreatment_pkey" PRIMARY KEY ("id");

ALTER TABLE "public"."surgerytreatment" ADD CONSTRAINT "fk_surgerytreatment_id" FOREIGN KEY ("id")
	REFERENCES "public"."treatment" ("id");

