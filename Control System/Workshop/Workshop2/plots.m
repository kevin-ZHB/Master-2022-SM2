close all
clear all

s = tf('s');

tau = [1 10 30];
K = [1 10 30];

% Keep tau = 1
for K = [1 10 30]
    sys = K/1*s+1);
    figure(1)
    step(sys);
    hold on 

    figure(2)
    bode(sys);
    hold on
end

% Keep K = 1
for tau = [1 10 30]
    sys = K(1)/(tau(1)*s+1);
    figure(3)
    step(sys);
    hold on 

    figure(4)
    bode(sys);
    hold on
end



    