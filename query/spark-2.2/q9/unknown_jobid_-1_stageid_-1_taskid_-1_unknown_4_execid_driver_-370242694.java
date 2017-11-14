/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private scala.collection.Iterator scan_input;
/* 012 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 014 */   private long scan_scanTime1;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 016 */   private int scan_batchIdx;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 028 */   private UnsafeRow agg_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     scan_input = inputs[0];
/* 048 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 049 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     scan_scanTime1 = 0;
/* 051 */     scan_batch = null;
/* 052 */     scan_batchIdx = 0;
/* 053 */     scan_colInstance0 = null;
/* 054 */     scan_colInstance1 = null;
/* 055 */     scan_result = new UnsafeRow(2);
/* 056 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 057 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 058 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 059 */     filter_result = new UnsafeRow(2);
/* 060 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 061 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 062 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 063 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 068 */     // initialize aggregation buffer
/* 069 */     agg_bufIsNull = false;
/* 070 */     agg_bufValue = 0L;
/* 071 */
/* 072 */     if (scan_batch == null) {
/* 073 */       scan_nextBatch();
/* 074 */     }
/* 075 */     while (scan_batch != null) {
/* 076 */       int scan_numRows = scan_batch.numRows();
/* 077 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 078 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 079 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 080 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 081 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 082 */
/* 083 */         if (!(!(scan_isNull))) continue;
/* 084 */
/* 085 */         boolean filter_isNull2 = false;
/* 086 */
/* 087 */         boolean filter_value2 = false;
/* 088 */         filter_value2 = scan_value >= 21;
/* 089 */         if (!filter_value2) continue;
/* 090 */         boolean filter_isNull5 = false;
/* 091 */
/* 092 */         boolean filter_value5 = false;
/* 093 */         filter_value5 = scan_value <= 40;
/* 094 */         if (!filter_value5) continue;
/* 095 */
/* 096 */         filter_numOutputRows.add(1);
/* 097 */
/* 098 */         // do aggregate
/* 099 */         // common sub-expressions
/* 100 */
/* 101 */         // evaluate aggregate function
/* 102 */         boolean agg_isNull1 = false;
/* 103 */
/* 104 */         long agg_value1 = -1L;
/* 105 */         agg_value1 = agg_bufValue + 1L;
/* 106 */         // update aggregation buffer
/* 107 */         agg_bufIsNull = false;
/* 108 */         agg_bufValue = agg_value1;
/* 109 */         // shouldStop check is eliminated
/* 110 */       }
/* 111 */       scan_batchIdx = scan_numRows;
/* 112 */       scan_batch = null;
/* 113 */       scan_nextBatch();
/* 114 */     }
/* 115 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 116 */     scan_scanTime1 = 0;
/* 117 */
/* 118 */   }
/* 119 */
/* 120 */   private void scan_nextBatch() throws java.io.IOException {
/* 121 */     long getBatchStart = System.nanoTime();
/* 122 */     if (scan_input.hasNext()) {
/* 123 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 124 */       scan_numOutputRows.add(scan_batch.numRows());
/* 125 */       scan_batchIdx = 0;
/* 126 */       scan_colInstance0 = scan_batch.column(0);
/* 127 */       scan_colInstance1 = scan_batch.column(1);
/* 128 */
/* 129 */     }
/* 130 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 131 */   }
/* 132 */
/* 133 */   private void wholestagecodegen_init_1() {
/* 134 */     agg_result = new UnsafeRow(1);
/* 135 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 136 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 137 */
/* 138 */   }
/* 139 */
/* 140 */   protected void processNext() throws java.io.IOException {
/* 141 */     while (!agg_initAgg) {
/* 142 */       agg_initAgg = true;
/* 143 */       long agg_beforeAgg = System.nanoTime();
/* 144 */       agg_doAggregateWithoutKey();
/* 145 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 146 */
/* 147 */       // output the result
/* 148 */
/* 149 */       agg_numOutputRows.add(1);
/* 150 */       agg_rowWriter.zeroOutNullBytes();
/* 151 */
/* 152 */       if (agg_bufIsNull) {
/* 153 */         agg_rowWriter.setNullAt(0);
/* 154 */       } else {
/* 155 */         agg_rowWriter.write(0, agg_bufValue);
/* 156 */       }
/* 157 */       append(agg_result);
/* 158 */     }
/* 159 */   }
/* 160 */ }
