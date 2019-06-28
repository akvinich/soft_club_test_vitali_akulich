package com.club.soft.scenario.framework.to;

import java.util.Objects;

public class Message implements Comparable<Message>, Cloneable {

    private String email;
    private String topic;
    private String text;

    public String getEmail() {
        return email;
    }

    public Message withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public Message withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message withText(String text) {
        this.text = text;
        return this;
    }

    public Message build() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return email.equals(message.email)
                && topic.equals(message.topic)
                && text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, topic, text);
    }

    @Override
    public int compareTo(Message o) {
        return this.text.length() * this.email.length() * this.topic.length()
                - o.text.length() * o.email.length() * o.topic.length();
    }

    @Override
    public Message clone() {
        Message clone = null;
        try {
            clone = (Message) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.email = (String) this.email;
        clone.topic = (String) this.topic;
        clone.text = (String) this.text;
        return clone;
    }
}
