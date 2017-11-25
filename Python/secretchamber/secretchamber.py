def main():
    n_translations, n_pairs = [int(x) for x in input().split()]

    translations = {}
    for i in range(26):
        translations.update({chr(i+97):[]})

    for i in range(n_translations):
        fr, to = input().split()
        translations.get(fr).append(to)

    for i in range(n_pairs):
        w_a, w_b = input().split()
        if len(w_a) != len(w_b):
            print("no")
            continue
        reachable = True
        for i in range(len(w_a)):
            if not check_reachable(translations, w_a[i], w_b[i], [False]*26):
                reachable = False
                break
        print("yes" if reachable else "no")

def check_reachable(translations, a, b, visited): # translations_dict, from, to
    if a == b:
        return True

    if a not in translations:
        return False

    if visited[ord(a)-97]:
        return False

    visited[ord(a)-97] = True

    reachable = False
    for letter in translations.get(a):
        reachable |= check_reachable(translations, letter, b, visited)

    return reachable

if __name__ == '__main__':
    main()
