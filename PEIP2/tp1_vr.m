clc
clear
close all

pkg load signal
pkg load image

disp("TP1");

N = 8;


disp(A1);

A1 = A1';

A1

figure(1)
imagesc(A1)
colormap(gray)
colorbar
title('Noyau A1')

input("Press <enter> to continue","s")


A1_tilda_t = zeros(N*N,1);

A1_tilda_t = A1(:);

Bases_DCT = A1_tilda_t * A1_tilda_t';

figure(2);
imagesc(Bases_DCT);
colormap(gray);
title('Les 64 sous images de DCT');


input("Press <enter> to continue","s");

for i = 1 : N*N

    for j = 1 : N*N

        if (Bases_DCT(i,j) >= 0)
            h2(i,j) = 1;
        else
            h2(i,j) = -1;
        end

    end

end

figure(4)
imagesc(h2)
colormap(gray)