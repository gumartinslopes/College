import numpy as np
import math

def histogram_equalization(img, max_value):
    n = img.size
    factor = max_value / n
    values, h = np.unique(img,return_counts = True)
    sum_h = np.cumsum(h)
    r = [math.floor(hi * factor) for hi in sum_h]
    result = img
    for i,value in enumerate(values):
        result = np.where(result == value,r[i], result )
    return result

def mean_filter(img, f_dim):
    result = []
    r_dim = (img.shape[0] - f_dim[0] + 1, img.shape[1] - f_dim[1] + 1)
    for i in range(r_dim[0]):
        result.append([])
        for j in range(r_dim[1]):
            arr = img[i: f_dim[0] + i, j:f_dim[1] + j]
            result[i].append(round(arr.mean()))
    return np.array(result).transpose()

def median_filter(img, f_dim):
    result = []
    r_dim = (img.shape[0] - f_dim[0] + 1, img.shape[1] - f_dim[1] + 1)
    for i in range(r_dim[0]):
        result.append([])
        for j in range(r_dim[1]):
            arr = img[i: f_dim[0] + i, j:f_dim[1] + j]
            result[i].append(np.median(arr))
    return np.array(result).transpose()

def create_padding_1d(img, pad):
    padded_img_width = img.shape[0] + 2*pad
    padded_img = np.zeros(padded_img_width)
    # populating padded image
    for i in range(len(img)):
        padded_img[i + pad] = img[i]
    return padded_img

def create_padding_2d(img, pad):
    padded_img_width = img.shape[0] + 2*pad[0]
    padded_img_height = img.shape[1] + 2*pad[1]
    
    padded_img = np.zeros((padded_img_width, padded_img_height))
    # populating padded image
    for i in range(len(img)):
        for j in range(len(img[i])):
            padded_img[i + pad[0]][j+pad[1]] = img[i][j]
    return padded_img

def conv_1d(img, f):
    result = []
    padded_img = create_padding_1d(img, len(f) - 1)
    # Applying the filter
    for i in range((len(img) + len(f)) - 1):
       arr = padded_img[i:len(f) + i] 
       filter_sum = sum(arr * f)
       result.append(filter_sum)
    return result

def conv_2d(img, f):
    result = []
    padded_img = create_padding_2d(img, (len(f) - 1, len(f[0]) - 1))
    # Applying the filter
    for i in range((len(img) + len(f)) - 1):
        result.append([])
        for j in range(len(img[0]) + len(f[0]) - 1):
            arr = padded_img[i:len(f) + i, j:len(f[0]) + j]
            conv_result = arr * f
            filter_sum = sum([sum(line) for line in conv_result])
            result[i].append(filter_sum)
    return np.array(result)

    
img = np.array([1,2,0,2,1])
f = np.array([3,2,1,2,3])
# print(conv_1d(img, f))
# print(conv_1d(f, img))

img_2d = np.array([[1,2],[2,3]])
f_2d = np.array([[1, 2, 1], [2, 8, 2], [1, 2, 1]])
# print(conv_2d(img_2d, f_2d))
# print(conv_2d(f_2d, img_2d))

img2 = np.array(
    [
    [3, 5, 2, 1, 1],
    [1, 4, 6, 2, 1],
    [1, 1, 5, 6, 2],
    [1, 1, 1, 1, 1],
    [1, 2, 2, 2, 1]
])

img3 = np.array(
    [
    [5, 1, 2, 1, 8],
    [6, 6, 5, 6, 1],
    [2, 1, 8, 7, 7],
    [6, 1, 2, 8, 8],
    [7, 8, 2, 1, 1]
])

img4 = np.array(
    [
    [1, 1, 9, 1, 1],
    [1, 1, 9, 8, 7],
    [9, 9, 9, 2, 1],
    [1, 1, 2, 8, 8],
    [1, 2, 2, 8, 9]
])

img_5 = np.array(
    [
    [0,1,2,2,1,1],
    [3,4,5,3,2,1],
    [2,2,3,4,5,1],
    [1,1,1,2,2,3],
    [4,5,5,4,3,3],
    [2,1,1,1,0,0]
    ]
)

print(histogram_equalization(img2, 255), end = '\n\n')
print(histogram_equalization(img3, 255), end = '\n\n') 
print(histogram_equalization(img4, 255), end = '\n\n')
#print(histogram_equalization(img_5, 180))