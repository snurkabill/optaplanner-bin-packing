package snurkabill.net;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import snurkabill.net.domain.Bin;
import snurkabill.net.domain.BinPacking;
import snurkabill.net.domain.Brick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinPackingGenerator {

    public static BinPacking simpleSolution() {
        BinPacking binPacking = new BinPacking();
        String string = String.valueOf(Integer.MIN_VALUE) + "hard";
        string += "/";
        string += String.valueOf(Integer.MIN_VALUE) + "soft";
        binPacking.setScore(HardSoftScore.parseScore(string));

        List<Bin> binList = new ArrayList<Bin>();
        Bin bin = new Bin();
        bin.setVolume(10);
        binList.add(bin);

        bin = new Bin();
        bin.setVolume(20);
        binList.add(bin);

        List<Brick> brickList = new ArrayList<Brick>();
        Brick brick = new Brick();
        brick.setVolume(9);
        brickList.add(brick);
        brick = new Brick();
        brick.setVolume(2);
        brickList.add(brick);

        binPacking.setBinList(binList);
        binPacking.setBrickList(brickList);
        return binPacking;
    }

    public static BinPacking generateSolution(int binNum, int bricksNum, int seed) {

            Random random = new Random(seed);

            int binVolumeRange = 900;
            int binVolumeBaseline = 500;

            int brickVolumeRange = 690;
            int brickVolumeBaseline = 10;

            BinPacking binPacking = new BinPacking();
            String string = String.valueOf(Integer.MIN_VALUE) + "hard";
            string += "/";
            string += String.valueOf(Integer.MIN_VALUE) + "soft";
            binPacking.setScore(HardSoftScore.parseScore(string));

            List<Bin> binList = new ArrayList<Bin>();
            for (int i = 0; i < binNum; i++) {
                Bin bin = new Bin();
                bin.setVolume(random.nextInt(binVolumeRange) + binVolumeBaseline);
                binList.add(bin);
            }

            List<Brick> brickList = new ArrayList<Brick>();
            for (int i = 0; i < bricksNum; i++) {
                Brick brick = new Brick();
                brick.setVolume(random.nextInt(brickVolumeRange) + brickVolumeBaseline);
                brickList.add(brick);
            }
            binPacking.setBinList(binList);
            binPacking.setBrickList(brickList);
            return binPacking;
    }
}
