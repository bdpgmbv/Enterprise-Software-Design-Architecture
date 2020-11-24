--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."sequence" DROP CONSTRAINT "sequence_pkey";

DROP INDEX "public"."sequence_pkey";

DROP TABLE "public"."sequence";

CREATE TABLE "public"."sequence" (
		"seq_name" VARCHAR(50) NOT NULL,
		"seq_count" NUMERIC(38 , 0)
	);

CREATE UNIQUE INDEX "public"."sequence_pkey" ON "public"."sequence" ("seq_name" ASC);

ALTER TABLE "public"."sequence" ADD CONSTRAINT "sequence_pkey" PRIMARY KEY ("seq_name");

