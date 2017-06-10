"""
    This module is used to determine if a credit card number
    is valid. The way it does it checks 2 sets of numbers from the input
    and does 3 different checks. The length of the digits, what type of
    card, and if it is a valid number.
"""


def is_valid_length(cred_num):
    """
    Checks if the number is of correct size from 13 to 16 digits

    Arguments:
        :param cred_num (str): the input card number

    Returns:
        bool: True if successful, False otherwise.
    """
    card_length = len(cred_num)
    if 16 <= card_length >= 13:
        return True
    else:
        return False


def card_type(cred_num):
    """
    Checks the first 2 digits of the input to check type of card.

    Arguments:
        :param cred_num (str): the input card number

    Returns:
        str: Type of Card
    """
    card_start = cred_num[0:2]
    if card_start[0] is '3' and card_start[1] is '7':
        return 'American Express'
    elif card_start[0] is '4':
        return 'Visa'
    elif card_start[0] is '5':
        return 'Master Card'
    elif card_start[0] is '6':
        return 'Discover Card'
    else:
        return 'Card Invalid'


def card_validation(cred_num):
    """
    Slices the input into 2 list of every other number.
    The First list elements are taking and multiplied by 2, if the sum exceeds
    single digit, its broken up and added to the list replacing the double digit.
    The Second list is the other numbers not from the first list and are Summed.

    Arguments:
        :param cred_num (str): the input card number

    Returns:
        int, int: the sums of both list
    """
    cred = cred_num
    cred_even = cred[::2]
    # print(cred_even[::-1])
    sum_even = [int(even) * 2 for even in cred_even]
    for x in sum_even:
        if x > 9:
            adjust_even = 1 + (x % 10)
            sum_even.append(adjust_even)
    for x in sum_even:
        if x > 9:
            sum_even.remove(x)
    # print(sum_even[::-1])
    # 10 doesnt get removed
    sum_e_tot = [el for el in sum_even if el <= 9]
    a = sum(sum_e_tot)
    # print('Sum for evens: ', a)
    cred_odd = cred[1::2]
    # print(cred_odd[::-1])
    sum_odd = [int(odd) for odd in cred_odd]
    b = sum(sum_odd)
    # print('Sum for Odds: ', b)
    return a, b


def is_card_valid(cred_num):
    """
    Checks the sum of the lists totals then take the mod of total
    to determine if valid or not

    Arguments:
        :param cred_num (str): the input card number

    Returns:
        str: state of the card number if valid or not
    """
    a, b = card_validation(cred_num)
    tot_valid = a + b
    is_valid = 'Valid' if tot_valid % 10 == 0 else 'Not Valid'
    return is_valid


def main():
    """
    main method
    user is given menu to choose whether to input a card number to validate
    or not
    """
    # is_valid_length(cred_num)
    # name = card_type(cred_num)
    # print(name)

    text_num = 0
    while text_num != 2:
        print('=' * 3, 'Credit Card Validation', '=' * 3)
        print('1. Validate Number')
        print('2. Exit Program')
        print('=' * 30)
        text_num = int(input('Menu Choice: '))
        if text_num is 1:
            cred_num = input('Please enter a Credit Card Number: \n')
            # is_card_valid(cred_num)
            good = is_valid_length(cred_num)
            if good is not True:
                print('Not a Valid Length of Digits. Please re-Enter.')
            else:
                print('Credit Card Number: ', cred_num)
                print('Credit Type: ', card_type(cred_num))
                print('All Good ? : ', is_card_valid(cred_num))
                print('\n\n\n')
        if text_num is 2:
            print('Good-Bye!')


# main()

# test Number
# 4388576018402626  Visa not valid
# 4888576018402626  Visa valid
# 3788576018402626  American Express not Valid
# 5388576018402626  Master Card not valid
# 6388576018402626  Discover Card valid