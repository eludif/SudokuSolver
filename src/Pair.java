class Pair<F,S> {
    private F first;
    private S second;

    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    F getFirst() { return first; }
    S getSecond() { return second; }
}