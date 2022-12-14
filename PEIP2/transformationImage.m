disp("Transformation d'une image");

image = imread('cameraman.tif');
N = 8;

%Affichage
figure(1);
imshow(image);

dimage = double(image);

[row,col] = size(dimage);

bloc_V = floor(row/N);
bloc_H = floor(col/N);

row_cadre = bloc_V*N;
col_cadre = bloc_H*N;

dimage = dimage(1:row_cadre,1:col_cadre);

%figure(2)
%imshow(uint8(dimage));


A1 = zeros(N);

for i = 1 : N
    for y = 1 : N
        
        alpha = sqrt(2);

        if y == 1
            alpha = 1;
        end

        A1(i,y) = (alpha / sqrt(N)) * cos( ( (2*i-1)*(y-1)*pi ) / (2*N) );

    end
end

A1 = A1';


%%%%Transformation%%%%

image_trans = zeros(row_cadre,col_cadre);

for ii = 1 : bloc_V
    for jj = 1 : bloc_H

        %Prelevement d'un bloc

        bloc_f = zeros(N);

        for i = 1 : N
            for j = 1 : N
                bloc_f(i,j) = dimage( (ii-1)*N+i , (jj-1)*N+j );
            end
        end

        %Transformation

        bloc_F = zeros(N);

        bloc_F = A1 * bloc_f * A1';

        %Recopie du bloc F

        for i = 1 : N
            for j = 1 : N
                image_trans( (ii-1)*N+i , (jj-1)*N+j ) = bloc_F(i,j);
            end
        end
    end
end

%figure(3);
%imagesc(image_trans);

%Histogramme

%figure(4);
%hist(int16(image_trans),64)

% Quantification

image_TQ = zeros(row_cadre,col_cadre);

for ii = 1 : bloc_V
    for jj = 1 : bloc_H

        %Prelevement d'un bloc


        for i = 1 : N
            for j = 1 : N
                bloc_F(i,j) = image_trans( (ii-1)*N+i , (jj-1)*N+j );
            end
        end

        %Quantification

        bloc_FQ = zeros(N);

        %bloc_FQ = bloc_F;

        bloc_FQ(1,1) = bloc_F(1,1);

        %bloc_FQ(2,1) = bloc_F(2,1);
        %bloc_FQ(3,1) = bloc_F(3,1);
        %bloc_FQ(4,1) = bloc_F(4,1);

        %bloc_FQ(1,2) = bloc_F(1,2);
        %bloc_FQ(1,3) = bloc_F(1,3);
        %bloc_FQ(1,4) = bloc_F(1,4);

        for i = 1 : N
            for j = 1 : N
                image_TQ( (ii-1)*N+i , (jj-1)*N+j ) = bloc_FQ(i,j);
            end
        end

    end
end

%figure(6)
%imagesc(image_TQ)

    
% Transformation inverse

image_r = zeros(row_cadre,col_cadre);

for ii = 1 : bloc_V
    for jj = 1 : bloc_H

        %Prelevement d'un bloc

        bloc_FQ2 = zeros(N);

        for i = 1 : N
            for j = 1 : N
                bloc_FQ2(i,j) = image_TQ( (ii-1)*N+i , (jj-1)*N+j );
            end
        end

        %Transformation

        bloc_f_R = zeros(N);

        bloc_f_R = A1' * bloc_FQ2 * A1;

        %Recopie du bloc F

        for i = 1 : N
            for j = 1 : N
                image_r( (ii-1)*N+i , (jj-1)*N+j ) = bloc_f_R(i,j);
            end
        end
    end
end

image_fin = uint8(image_r)

figure(5)
imshow(uint8(image_r))

image_diff = double(dimage - image_r)
disp("Erreur max positive entre 2 pixel")
max( max(image_diff) )
disp("Erreur max negative entre 2 pixel")
min( min(image_diff) )