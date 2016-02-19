package snurkabill.net.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.Collection;
import java.util.List;

@PlanningSolution
public class BinPacking implements Solution<HardSoftScore> {

    private HardSoftScore score;

    private List<Bin> bins;
    private List<Brick> bricks;

        @ValueRangeProvider(id = "bins")
    public List<Bin> getBinList() {
        return bins;
    }

    @PlanningEntityCollectionProperty
    public List<Brick> getBrickList() {
        return bricks;
    }

    public void setBrickList(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public void setBinList(List<Bin> bins) {
        this.bins = bins;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public Collection<?> getProblemFacts() {
        return null;
    }
}
