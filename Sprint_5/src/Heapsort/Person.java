package Heapsort;

class Person implements Comparable<Person> {
    private final String name;

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getFines() {
        return fines;
    }

    private final int points;
    private final int fines;

    public Person(String name, int points, int fines) {
        this.name = name;
        this.points = points;
        this.fines = fines;
    }

    @Override
    public int compareTo(Person o) {
        if (points < o.getPoints()) {
            return 1;
        } else if (points > o.getPoints()) {
            return -1;
        } else if (fines > o.getFines()) {
            return 1;
        } else if (fines < o.getFines()) {
            return -1;
        } else return Integer.compare(name.compareTo(o.getName()), 0);
    }

    void printName() {
        System.out.println(name);
    }
}
