package com.eveningoutpost.dexdrip.UtilityModels.music;

public class MusicState{
    public static final int STATE_PLAYING = 0;
    public static final int STATE_PAUSED  = 1;
    public static final int STATE_STOPPED = 2;
    public static final int STATE_UNKNOWN = 3;

    public byte state;
    public int position; // Position of the current media in seconds
    public int playRate; // Speed of playback, usually 0 or 100 (full speed)
    public byte shuffle;
    public byte repeat;

    public MusicState() {

    }

    public MusicState(MusicState old) {
        this.state = old.state;
        this.position = old.position;
        this.playRate = old.playRate;
        this.shuffle = old.shuffle;
        this.repeat = old.repeat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MusicState)) {
            return false;
        }
        MusicState stateSpec = (MusicState) obj;

        return this.state == stateSpec.state &&
                Math.abs(this.position - stateSpec.position)<=2 &&
                this.playRate == stateSpec.playRate &&
                this.shuffle == stateSpec.shuffle &&
                this.repeat == stateSpec.repeat;
    }

    @Override
    public int hashCode() {
        int result = (int) state;
//ignore the position -- it is taken into account in equals()
//result = 31 * result + position;
        result = 31 * result + playRate;
        result = 31 * result + (int) shuffle;
        result = 31 * result + (int) repeat;
        return result;
    }

    @Override
    public String toString() {
        return "MusicState{" +
                "state=" + state +
                ", position=" + position +
                ", playRate=" + playRate +
                ", shuffle=" + shuffle +
                ", repeat=" + repeat +
                '}';
    }
}