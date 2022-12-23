% LEGO EV3 robot simulink model parameters - ELEN90055 Workshops 3
clear all
Ts = 0.005;          % sensor / control sampling time (s)

SqWaveFreq = 1/6;    % frequency of test signal and reference repetition (Hz)

Vm = 30;             % percentage of supply voltage applied by PWM to motor during tests

Km = 7;            % V-to-ThetaDot motor model gain parameter (degrees/V.s) 
Tm = 0.4;          % V-to-ThetaDot motor model time-constant (s)

To = 0.02;          % open-loop controller roll-off
Km0 = 6.95;
Tm0 = 0.095;
COL = tf([Tm0 1 0],Km0*[To^2 2*To 1]);  % open-loop controller = approx inverse of Km0/s*(Tm0 s + 1)
COLdisc = c2d(COL,Ts,'tustin');         % time discretization of open-loop controller
[COLnum,COLden] = tfdata(COLdisc,'v');  % discrete transfer fnc numerator and denominator 

ThDotRef = 210;      % ThetaDot reference for test under feedback control

Kc = 4;              % feedback controller gain for drive motors



