def main():
    base_word = input()

    num_sounds_lists = int(input())
    sounds = set()
    for i in range(num_sounds_lists):
        sound_list = input().split()
        for sound in sound_list:
            if sound_in_word(sound, base_word):
                sounds.update(set(sound_list))

    num_phrases = int(input())

    for i in range(num_phrases):
        last_word = input().split()[-1]
        found = False

        for sound in sounds:
            if sound_in_word(sound, last_word):
                print("YES")
                found = True
                break
        if not found:
            print("NO")

def sound_in_word(sound, word):
    if len(sound) > len(word):
        return False

    if word[len(word) - len(sound):] == sound:
        return True
    return False

if __name__ == '__main__':
    main()