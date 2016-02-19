package snurkabill.net.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Brick {

    private int volume;

    private Bin bin;

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @PlanningVariable(valueRangeProviderRefs = {"bins"})
    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public int getVolume() {
        return volume;
    }
}
