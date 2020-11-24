--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."provider" DROP CONSTRAINT "provider_pkey";

DROP INDEX "public"."provider_pkey";

DROP TABLE "public"."provider";

CREATE TABLE "public"."provider" (
		"id" INT8 NOT NULL,
		"name" VARCHAR(255),
		"npi" INT8,
		"providertype" INT4
	);

CREATE UNIQUE INDEX "public"."provider_pkey" ON "public"."provider" ("id" ASC);

ALTER TABLE "public"."provider" ADD CONSTRAINT "provider_pkey" PRIMARY KEY ("id");

