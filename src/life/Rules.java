package life;

public enum Rules {
    
    NONE,
    BORN,
    LIFE,
    DIE;
    
    public Rules generation1(int around) {
        switch(this) {
            case NONE: return (around == 3) ? BORN : NONE;
            case LIFE: return (around <= 1 || around >= 4) ? DIE : LIFE;
            default: return this;
        }
    }
    
    public Rules generation2() {
        switch(this) {
            case BORN: return LIFE;
            case DIE: return NONE;
            default: return this;
        }
    }
    
    public boolean isCell() {
        return this == LIFE || this == DIE;
    }
    
    
}
