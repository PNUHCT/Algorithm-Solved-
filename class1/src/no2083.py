class StringTokenizer:
    def __init__(self, string, delimiters):
        self.string = string
        self.delimiters = delimiters
        self.tokens = self.tokenize()

    def tokenize(self):
        token_list = []
        current_token = ""
        for char in self.string:
            if char in self.delimiters:
                if current_token:
                    token_list.append(current_token)
                    current_token = ""
            else:
                current_token += char
        if current_token:
            token_list.append(current_token)
        return token_list

    def count_tokens(self):
        return len(self.tokens)

    def get_token(self, index):
        if index < 0 or index >= len(self.tokens):
            return None
        return self.tokens[index]

while 1 :
    delimiters = " "
    tokenizer = StringTokenizer(input(), delimiters)

    name = tokenizer.get_token(0)

    if name == "#" : break
    if int(tokenizer.get_token(1)) >17 or int(tokenizer.get_token(2)) >=80 : print(name + " Senior")
    else : print(name + " Junior")


    # 단순 split()
    # name, age, weight = input().split()
    # if '#' in name : break

    # if int(age)>17 or int(weight)>=80 : print(f"{name} Senior")
    # else : print(f"{name} Junior")