package cc.morawiec.apps.Poker;

public enum Levels {
    LEVEL_1 (25,50,false,0),
    LEVEL_2 (50,100,false,0),
    LEVEL_3 (100,200,true,25),
    LEVEL_4 (150,300,false,0),
    LEVEL_5 (200,400,false,0),
    LEVEL_6 (250,500,false,0),
    LEVEL_7 (300,600,false,0),
    LEVEL_8 (400,800,false,0),
    LEVEL_9 (500,1000,false,0);

    private int smallBlind;
    private int bigBlind;
    private boolean isAnte;
    private int ante;

    Levels (int sB, int bB, boolean isAnte, int ante)
    {
        this.bigBlind = bB;
        this.smallBlind = sB;
        this.isAnte = isAnte;
        this.ante = ante;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public int getAnte() {
        return ante;
    }

    public boolean isAnte() {
        return isAnte;
    }
}
