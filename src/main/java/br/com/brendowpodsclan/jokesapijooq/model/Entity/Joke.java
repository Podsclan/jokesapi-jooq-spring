package br.com.brendowpodsclan.jokesapijooq.model.Entity;

public class Joke {
    private int id;
    private String type;
    private String joke;
    private Author author;

    public Joke(int id, String type, String joke, Author author) {
        this.id = id;
        this.type = type;
        this.joke = joke;
        this.author = author;
    }

    public Joke() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
