package snurkabill.net;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class BinPackingRunner {

    public static void main(String[] args) {
        SolverFactory factory = SolverFactory
                .createFromXmlInputStream(BinPackingRunner.class.getResourceAsStream("/snurkabill/net/config"));
        Solver solver = factory.buildSolver();
        solver.solve(BinPackingGenerator.generateSolution(400, 500, 0));
//        solver.solve(BinPackingGenerator.simpleSolution());
    }

}
