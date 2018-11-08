package ru.geekbrains.patterns.service.builder;

public class Email {

    private String header;
    private String from;
    private String to;
    private String copy;
    private String hiddenCopy;
    private String text;

    private Email() {

    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getCopy() {
        return copy;
    }

    public String getHiddenCopy() {
        return hiddenCopy;
    }

    @Override
    public String toString() {
        return "Email{" +
                "header='" + header + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", copy='" + copy + '\'' +
                ", hiddenCopy='" + hiddenCopy + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public static EmailBuilder builder() {
        return new EmailBuilder();
    }

    public static class EmailBuilder {

        private Email email;

        private EmailBuilder() {
            this.email = new Email();
        }

        public EmailBuilder withFrom(String from) {
            email.from = from;
            return this;
        }

        public EmailBuilder withTo(String to) {
            email.to = to;
            return this;
        }

        public EmailBuilder withCopy(String copy) {
            email.copy = copy;
            return this;
        }

        public EmailBuilder withHiddenCopy(String hiddenCopy) {
            email.hiddenCopy = hiddenCopy;
            return this;
        }

        public EmailBuilder withHeader(String header) {
            email.header = header;
            return this;
        }

        public EmailBuilder withText(String text) {
            email.text = text;
            return this;
        }

        public Email build() {
            if (email.from == null || email.to == null) {
                throw new IllegalArgumentException("From or To email is not assigned!");
            }
            return email;
        }

    }
}
