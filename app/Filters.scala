import common.AccumulatorFlowFilter
import play.api.http.{DefaultHttpFilters, EnabledFilters}

import javax.inject.Inject

/**
 * Play Filter 配置，在这里引入自己的 Filter
 * @param defaultFilters 系统默认的 Filter
 */
class Filters @Inject()(defaultFilters: EnabledFilters,
                        accumulatorFlowFilter: AccumulatorFlowFilter)
  extends DefaultHttpFilters(defaultFilters.filters :+ accumulatorFlowFilter: _*) {


}
