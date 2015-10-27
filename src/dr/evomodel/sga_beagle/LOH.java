/*
 * HKY.java
 * 
 * Modified from HKY.java by DM
 * 
 * Copyright (c) 2002-2015 Alexei Drummond, Andrew Rambaut and Marc Suchard
 *
 * This file is part of BEAST.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * BEAST is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 *  BEAST is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with BEAST; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package dr.evomodel.sga_beagle;

import dr.inference.model.Parameter;
import dr.inference.model.Statistic;
import dr.app.beagle.evomodel.substmodel.BaseSubstitutionModel;
import dr.app.beagle.evomodel.substmodel.FrequencyModel;
import dr.evolution.datatype.TwoStates;
import dr.math.matrixAlgebra.Vector;
import dr.evomodel.sga_beagle.LOH;


/**
 * LOH model of SGA evolution
 *
 * @author Diego Mallo
 */
public class LOH extends BaseSubstitutionModel {

    private Parameter alphaParameter = null;
    private Parameter betaParameter = null;

    /**
     * Constructor
     * @param kappaParameter
     * @param freqModel
     */
    public LOH(Parameter alphaParameter, Parameter betaParameter, FrequencyModel freqModel) {

        super("LOH", TwoStates.INSTANCE, freqModel);

        this.alphaParameter = alphaParameter;
        this.betaParameter =  betaParameter;
        addVariable(alphaParameter);
        addVariable(betaParameter);
        alphaParameter.addBounds(new Parameter.DefaultBounds(Double.POSITIVE_INFINITY, 0.0, 1));
        betaParameter.addBounds(new Parameter.DefaultBounds(Double.POSITIVE_INFINITY, 0.0, 1));
    }

    /**
     * set alpha
     * @param alpha
     */
    public void setAlpha(double alpha) {
        alphaParameter.setParameterValue(0, alpha);
        updateMatrix = true;
    }
    
    /**
     * set beta
     * @param beta
     */
    public void setBeta(double beta) {
        betaParameter.setParameterValue(0, beta);
        updateMatrix = true;
    }

    /**
     * @return alpha
     */
    public final double getAlpha() {
        return alphaParameter.getParameterValue(0);
    }
    
    /**
     * @return beta
     */
    public final double getBeta() {
        return betaParameter.getParameterValue(0);
    }

    protected void frequenciesChanged() {
    }

    protected void ratesChanged() {
    }

    protected void setupRelativeRates(double[] rates) {
 //       double kappa =  kappaParameter.getParameterValue(0);
 //       rates[0] = 1.0;
 //       rates[1] = kappa;
 //       rates[2] = 1.0;
 //       rates[3] = 1.0;
 //       rates[4] = kappa;
 //       rates[5] = 1.0;
    }

//  public synchronized EigenDecomposition getEigenDecomposition() {
//
//       if (eigenDecomposition == null) {
//           double[] evec = new double[stateCount * stateCount];
//           double[] ivec = new double[stateCount * stateCount];
//           double[] eval = new double[stateCount];
//           eigenDecomposition = new EigenDecomposition(evec, ivec, eval);
//
//           ivec[2 * stateCount + 1] =  1; // left eigenvectors 3 = (0,1,0,-1); 4 = (1,0,-1,0)
//           ivec[2 * stateCount + 3] = -1;
//
//           ivec[3 * stateCount + 0] =  1;
//           ivec[3 * stateCount + 2] = -1;
//
//           evec[0 * stateCount + 0] =  1; // right eigenvector 1 = (1,1,1,1)'
//           evec[1 * stateCount + 0] =  1;
//           evec[2 * stateCount + 0] =  1;
//           evec[3 * stateCount + 0] =  1;
//
//       }
//
//       if (updateMatrix) {
//
//           double[] evec = eigenDecomposition.getEigenVectors();
//           double[] ivec = eigenDecomposition.getInverseEigenVectors();
//           double[] pi = freqModel.getFrequencies();
//           double piR = pi[0] + pi[2];
//           double piY = pi[1] + pi[3];
//
//           // left eigenvector #1
//           ivec[0 * stateCount + 0] = pi[0]; // or, evec[0] = pi;
//           ivec[0 * stateCount + 1] = pi[1];
//           ivec[0 * stateCount + 2] = pi[2];
//           ivec[0 * stateCount + 3] = pi[3];
//
//           // left eigenvector #2
//           ivec[1 * stateCount + 0] =  pi[0]*piY;
//           ivec[1 * stateCount + 1] = -pi[1]*piR;
//           ivec[1 * stateCount + 2] =  pi[2]*piY;
//           ivec[1 * stateCount + 3] = -pi[3]*piR;
//
//           // right eigenvector #2
//           evec[0 * stateCount + 1] =  1.0/piR;
//           evec[1 * stateCount + 1] = -1.0/piY;
//           evec[2 * stateCount + 1] =  1.0/piR;
//           evec[3 * stateCount + 1] = -1.0/piY;
//
//           // right eigenvector #3
//           evec[1 * stateCount + 2] =  pi[3]/piY;
//           evec[3 * stateCount + 2] = -pi[1]/piY;
//
//           // right eigenvector #4
//           evec[0 * stateCount + 3] =  pi[2]/piR;
//           evec[2 * stateCount + 3] = -pi[0]/piR;
//
//           // eigenvectors
//           double[] eval = eigenDecomposition.getEigenValues();
//           final double kappa = getKappa();
//
//           final double beta = -1.0 / (2.0 * (piR * piY + kappa * (pi[0] * pi[2] + pi[1] * pi[3])));
//           final double A_R  =  1.0 + piR * (kappa - 1);
//           final double A_Y  =  1.0 + piY * (kappa - 1);
//
//           eval[1] = beta;
//           eval[2] = beta*A_Y;
//           eval[3] = beta*A_R;
//
//           updateMatrix = false;
//
//       }
//
//       return eigenDecomposition;
//   }
}