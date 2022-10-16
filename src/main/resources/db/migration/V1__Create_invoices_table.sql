CREATE TABLE public.invoices
(
    invoice_id uuid NOT NULL,
    issue_date date NOT NULL,
PRIMARY KEY (invoice_id)
);
