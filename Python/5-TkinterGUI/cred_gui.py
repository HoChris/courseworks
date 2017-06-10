"""
    This Module provided the GUI for the credValid Module.
    The User enter a credit card number and receives information
    if valid or not

"""
from tkinter import *
from credValid import *


def callback():
    """
        Function that executes calls to the credValid function and stores
        results to and empty string. String is inserted and outputted to User

    """
    s = ""
    text_box.delete(0.0, END)
    card = entry1.get()

    good = is_valid_length(card)

    if good is not True:
        s += 'Not a Valid Length of Digits. Please re-Enter.'
    else:
        s += 'Credit Card Number: ' + card + '\nCredit Type: ' + card_type(card) + '\nAll Good ? : ' \
             + is_card_valid(card)

    text_box.insert(0.0, s)


root = Tk()
root.title('Credit Card Validation')

label1 = Label(root, text='Please Enter your Card Number')


entry1 = Entry(root)
entry1.focus()

label1.pack()

entry1.pack()


valid_button = Button(root, text='Check', command=callback)
valid_button.pack()
quit_button = Button(root, text='Quit', command=root.quit)
quit_button.pack()

text_box = Text(root, height=4, width=20)
text_box.pack()


root.mainloop()
