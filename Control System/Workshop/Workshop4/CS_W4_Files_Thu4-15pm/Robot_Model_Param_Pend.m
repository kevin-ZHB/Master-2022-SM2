% Robot Pendulum simulink model parameters - ELEN90055 Workshop 4

close all

Ts = 0.005;          % sensor / control sampling time (s)


Kt = 0.192;
Kt_r = 1.66e-2;
Kb = 0.297;

b = 0.03;
l = 0.31;
m = 0.3;
g = 9.8;


alpha = (1-sind(45))/(1+sind(45));
tz = 1/(15*sqrt(alpha));
tp = alpha* tz;
K = 64;

COL = tf(K*[tz 1] ,[tp 1]);

% COL = pid(100,0,0);


COLdisc = c2d(COL,Ts,'tustin');         % time discretization of open-loop controller
[CPnum,CPden] = tfdata(COLdisc,'v');  % discrete transfer fnc numerator and denominator 

G=tf(9*180/100/pi*[Kt_r],[m*l^2 (b+Kt_r*Kb) -m*g*l]);
[Gnum, Gden] = tfdata(G,'v');
[Cnum, Cden] = tfdata(COL,'v');


lambda = COL*G;

T0 = lambda/(1+lambda);
[Tnum, Tden] = tfdata(T0,'v');

figure()
bode(G);
legend
hold on
bode(COL)

figure()
margin(lambda);

figure()
nyquist(lambda)

figure()
step(T0)




