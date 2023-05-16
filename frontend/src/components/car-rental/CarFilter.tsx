import {
  Accordion,
  Box,
  Checkbox,
  Flex,
  MultiSelect,
  RangeSlider,
} from "@mantine/core";
import CustomAccordionItem from "../common/CustomAccordionItem";
const marks = [
  { value: 0, label: "0 TRY" },
  { value: 10000, label: "10000 TRY" },
];

const CarFilter = () => {
  return (
    <Box w={"10vw"}>
      <Accordion
        multiple
        variant="contained"
        radius="xs"
        bg={"#B5B4E8"}
      >
        <CustomAccordionItem value={"Price Per Day Range"}>
          <RangeSlider defaultValue={[0, 10000]} marks={marks}></RangeSlider>
        </CustomAccordionItem>

        <CustomAccordionItem value={"Fuel"}>
          <Flex direction={"column"} gap={"xs"}>
            <Checkbox label="Gas" />
            <Checkbox label="Hybrid" />
            <Checkbox label="Electric" />
            <Checkbox label="Diesel" />
          </Flex>
        </CustomAccordionItem>

        <CustomAccordionItem value={"Gear"}>
          <Flex direction={"column"} gap={"xs"}>
            <Checkbox label="Automatic" />
            <Checkbox label="Manual" />
          </Flex>
        </CustomAccordionItem>
        <CustomAccordionItem value={"Car Category"}>
          <Flex direction={"column"} gap={"xs"}>
            <Checkbox label="Small" />
            <Checkbox label="Medium" />
            <Checkbox label="Large" />
            <Checkbox label="SUV" />
          </Flex>
        </CustomAccordionItem>
        <CustomAccordionItem value={"Car Brand"}>
          <MultiSelect
            data={[
              { value: "Volvo", label: "Volvo" },
              { value: "Honda", label: "Honda" },
              { value: "Hyundai", label: "Hyundai" },
            ]}
            placeholder="Pick all that you like"
          />
        </CustomAccordionItem>
      </Accordion>
    </Box>
  );
};
export default CarFilter;
