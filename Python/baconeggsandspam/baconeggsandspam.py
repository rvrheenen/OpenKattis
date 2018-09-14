def main():
    while True:
        num_customers = int(input())
        if num_customers == 0:
            break

        product_report = {}
        for _ in range(num_customers):
            order = input().split()

            for item in order[1:]:
                if item in product_report:
                    product_report[item].append(order[0])
                else:
                    product_report[item] = [order[0]]

        for item, names in sorted(product_report.items()):
            print(item, " ".join(sorted(names)))

        print()


if __name__ == '__main__':
    main()
