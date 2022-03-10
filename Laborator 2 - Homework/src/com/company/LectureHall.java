package com.company;

public class LectureHall extends Room {
    private Boolean VideoProjector;

    /*
        Constructorul clasei LectureHall
        @param name numele salii
        @param capacity capacitatea salii
        @param videoProjector variabila de tip boolean care indica daca in sala exista videoproiector sau nu
        @see LectureHall
     */
    public LectureHall(String name, int capacity, Boolean videoProjector) {
        super(name, capacity);
        VideoProjector = videoProjector;
    }

    /*
        Getterul variabilei  VideoProjector
        @return true daca exista videoproiector in sala, false in caz contrat
        @see LectureHall
    */
    public Boolean getVideoProjector() {
        return VideoProjector;
    }

    /*
        Setterul variabilei VideoProjector
        @param videoProjector true daca exista videoproiector, false in caz contrar
        @see LectureHall
     */
    public void setVideoProjector(Boolean videoProjector) {
        VideoProjector = videoProjector;
    }
}
