CREATE TABLE public.computers
(
computer_id uuid NOT NULL,
name varchar(100) NOT NULL,
account_date date NOT NULL,
usd_Cost numeric(10,2) NOT NULL DEFAULT 0,
pln_Cost numeric(10,2) NOT NULL DEFAULT 0,
invoice_id uuid,
CONSTRAINT invoice_fk FOREIGN KEY(invoice_id) REFERENCES public.invoices(invoice_id),
PRIMARY KEY (computer_id)
);
