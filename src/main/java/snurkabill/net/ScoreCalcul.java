package snurkabill.net;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import snurkabill.net.domain.Bin;
import snurkabill.net.domain.BinPacking;
import snurkabill.net.domain.Brick;

public class ScoreCalcul implements EasyScoreCalculator<BinPacking> {

    public Score calculateScore(BinPacking binPacking) {
        int hardScore = 0;
        int softScore = 0;
        for (Bin bin : binPacking.getBinList()) {
            int usage = 0;
            for (Brick brick : binPacking.getBrickList()) {
                if(bin.equals(brick.getBin())) {
                    usage += brick.getVolume();
                }
            }
            if(usage > bin.getVolume()) {
                hardScore -= usage - bin.getVolume();
            }
            if(usage != 0) {
                softScore--;
            }
        }
        return HardSoftScore.valueOf(hardScore, softScore);
    }
}
