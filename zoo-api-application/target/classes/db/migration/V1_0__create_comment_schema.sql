CREATE TABLE COMMENT (
	ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
	CREATED_DATE TIMESTAMP,
	TEXT CHARACTER VARYING(255),
	AUTHOR CHARACTER VARYING(30),
	ARTICLE_ID BIGINT,

	CONSTRAINT COMMENT_PK PRIMARY KEY (ID)
)