import * as React from "react";
import * as ReactDOM from "react-dom";
import TimelineView from "../TimelineView";

interface FoundationProps {}

class Foundation extends React.Component<FoundationProps, {}> {
  constructor(props: FoundationProps) {
    super(props);
  }
  render() {
    return (
      <div className="foundation">
        <h1 className="foundation__heading">Foundation of Facts</h1>
        <TimelineView />
      </div>
    );
  }
}

export default Foundation;
