CREATE TABLE public.cliente
(
  id integer NOT NULL, 
  nome character varying(255) NOT NULL,
  score numeric(29,16), 
  CONSTRAINT pk_cliente_id PRIMARY KEY (id)
)
