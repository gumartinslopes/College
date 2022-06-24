import pandas
import numpy

class Perceptron():    
    def __init__(self, params=None):
        if (params == None):
            self.inputLayer = 2
            self.Bias = -1
            self.number_of_columns = 0
            self.number_of_rows = 0
            self.matrix_data = []
            self.weight = []
            self.real_result = []
            self.pred_result = numpy.empty(0, dtype=int)
            self.learning_rate = 0.2
            self.epoch = 50
            self.accuracy = 0
            self.bias = numpy.random.rand(1, 1)
    
    def read_csv(self, params):
        df = pandas.read_csv(params)
        
        self.real_result = df.iloc[: , -1].to_numpy() # Get column classifier
        df.drop(df.columns[len(df.columns)-1], axis=1, inplace=True) # Delete column classifier
        
        self.number_of_columns = len(df.columns)
        self.number_of_rows = len(df.index)
        self.matrix_data = df.to_numpy()
        self.weight = numpy.random.rand(self.number_of_columns, 1)
        
    def activation_function(self, params):
        if params > 0:
            return 1
        else:
            return 0
        
    def fit(self):
        e = 0

        while e <= self.epoch and self.accuracy <= 0.95:
            print(10 * '=', 'Epoch', e, 10 * '=')
            for i in range(0, self.number_of_rows):
                sum = 0
                
                for j in range(0, self.number_of_columns):
                    sum += self.matrix_data[i, j] * self.weight[j]

                result = self.activation_function(sum + self.bias)
                self.calculate_error(self.real_result[i], result, self.matrix_data[i, :])
                self.pred_result = numpy.append(self.pred_result, result)
                
            self.calculate_accuracy(self.pred_result, self.real_result)
            print('Accuracy =', self.accuracy)
            print('Resultado esperado =', self.real_result)
            print('Resultado obtido =', self.pred_result, "\n")
            self.pred_result = numpy.empty(0, dtype=int)
            e += 1
            
                
    def calculate_error(self, target, prediction, input):
        error = target - prediction;
        
        for j in range(0, self.number_of_columns):
            new_weight = self.weight[j] + self.learning_rate * error * input[j]
            self.weight[j] = new_weight
            self.bias = self.bias + self.learning_rate * error
            
    def calculate_accuracy(self, classification_scores, true_labels):
        true_values = 0
        for i in range(0, len(true_labels)):
            if classification_scores[i] == true_labels[i]:
                true_values += 1
        
        self.accuracy = true_values / len(true_labels)

def main():
    perceptron = Perceptron()
    perceptron.read_csv('AND.csv')
    perceptron.fit()
    
if __name__ == '__main__':
    main()