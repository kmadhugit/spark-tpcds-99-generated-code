/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator scan_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 018 */   private long scan_scanTime1;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 020 */   private int scan_batchIdx;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 024 */   private UnsafeRow scan_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private UnsafeRow agg_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 037 */   private int agg_value2;
/* 038 */   private UnsafeRow agg_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 043 */
/* 044 */   public GeneratedIterator(Object[] references) {
/* 045 */     this.references = references;
/* 046 */   }
/* 047 */
/* 048 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 049 */     partitionIndex = index;
/* 050 */     this.inputs = inputs;
/* 051 */     wholestagecodegen_init_0();
/* 052 */     wholestagecodegen_init_1();
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void wholestagecodegen_init_0() {
/* 057 */     agg_initAgg = false;
/* 058 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 059 */
/* 060 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 061 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 062 */     scan_input = inputs[0];
/* 063 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 064 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 065 */     scan_scanTime1 = 0;
/* 066 */     scan_batch = null;
/* 067 */     scan_batchIdx = 0;
/* 068 */     scan_colInstance0 = null;
/* 069 */     scan_colInstance1 = null;
/* 070 */     scan_colInstance2 = null;
/* 071 */     scan_result = new UnsafeRow(3);
/* 072 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 073 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 074 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 075 */     filter_result = new UnsafeRow(3);
/* 076 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   private void scan_nextBatch() throws java.io.IOException {
/* 081 */     long getBatchStart = System.nanoTime();
/* 082 */     if (scan_input.hasNext()) {
/* 083 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 084 */       scan_numOutputRows.add(scan_batch.numRows());
/* 085 */       scan_batchIdx = 0;
/* 086 */       scan_colInstance0 = scan_batch.column(0);
/* 087 */       scan_colInstance1 = scan_batch.column(1);
/* 088 */       scan_colInstance2 = scan_batch.column(2);
/* 089 */
/* 090 */     }
/* 091 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 092 */   }
/* 093 */
/* 094 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 095 */     agg_hashMap = agg_plan.createHashMap();
/* 096 */
/* 097 */     if (scan_batch == null) {
/* 098 */       scan_nextBatch();
/* 099 */     }
/* 100 */     while (scan_batch != null) {
/* 101 */       int scan_numRows = scan_batch.numRows();
/* 102 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 103 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 104 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 105 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 106 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 107 */
/* 108 */         if (!(!(scan_isNull1))) continue;
/* 109 */
/* 110 */         boolean filter_isNull2 = false;
/* 111 */
/* 112 */         boolean filter_value2 = false;
/* 113 */         filter_value2 = scan_value1 == 2000;
/* 114 */         if (!filter_value2) continue;
/* 115 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 116 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 117 */
/* 118 */         if (!(!(scan_isNull2))) continue;
/* 119 */
/* 120 */         boolean filter_isNull7 = false;
/* 121 */
/* 122 */         boolean filter_value7 = false;
/* 123 */         filter_value7 = scan_value2 == 1;
/* 124 */         if (!filter_value7) continue;
/* 125 */
/* 126 */         filter_numOutputRows.add(1);
/* 127 */
/* 128 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 129 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 130 */
/* 131 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 132 */
/* 133 */         UnsafeRow agg_fastAggBuffer = null;
/* 134 */
/* 135 */         if (agg_fastAggBuffer == null) {
/* 136 */           // generate grouping key
/* 137 */           agg_rowWriter.zeroOutNullBytes();
/* 138 */
/* 139 */           if (scan_isNull) {
/* 140 */             agg_rowWriter.setNullAt(0);
/* 141 */           } else {
/* 142 */             agg_rowWriter.write(0, scan_value);
/* 143 */           }
/* 144 */           agg_value2 = 42;
/* 145 */
/* 146 */           if (!scan_isNull) {
/* 147 */             agg_value2 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value2);
/* 148 */           }
/* 149 */           if (true) {
/* 150 */             // try to get the buffer from hash map
/* 151 */             agg_unsafeRowAggBuffer =
/* 152 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 153 */           }
/* 154 */           if (agg_unsafeRowAggBuffer == null) {
/* 155 */             if (agg_sorter == null) {
/* 156 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 157 */             } else {
/* 158 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 159 */             }
/* 160 */
/* 161 */             // the hash map had be spilled, it should have enough memory now,
/* 162 */             // try  to allocate buffer again.
/* 163 */             agg_unsafeRowAggBuffer =
/* 164 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 165 */             if (agg_unsafeRowAggBuffer == null) {
/* 166 */               // failed to allocate the first page
/* 167 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 168 */             }
/* 169 */           }
/* 170 */         }
/* 171 */
/* 172 */         if (agg_fastAggBuffer != null) {
/* 173 */           // update fast row
/* 174 */
/* 175 */         } else {
/* 176 */           // update unsafe row
/* 177 */
/* 178 */           // common sub-expressions
/* 179 */
/* 180 */           // evaluate aggregate function
/* 181 */
/* 182 */           // update unsafe row buffer
/* 183 */
/* 184 */         }
/* 185 */         // shouldStop check is eliminated
/* 186 */       }
/* 187 */       scan_batchIdx = scan_numRows;
/* 188 */       scan_batch = null;
/* 189 */       scan_nextBatch();
/* 190 */     }
/* 191 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 192 */     scan_scanTime1 = 0;
/* 193 */
/* 194 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 195 */   }
/* 196 */
/* 197 */   private void wholestagecodegen_init_1() {
/* 198 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 199 */     project_result = new UnsafeRow(1);
/* 200 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 201 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 202 */     agg_result = new UnsafeRow(1);
/* 203 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 204 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 205 */
/* 206 */     agg_result1 = new UnsafeRow(1);
/* 207 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 208 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 209 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 210 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 211 */
/* 212 */   }
/* 213 */
/* 214 */   protected void processNext() throws java.io.IOException {
/* 215 */     if (!agg_initAgg) {
/* 216 */       agg_initAgg = true;
/* 217 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 218 */       agg_doAggregateWithKeys();
/* 219 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 220 */     }
/* 221 */
/* 222 */     // output the result
/* 223 */
/* 224 */     while (agg_mapIter.next()) {
/* 225 */       wholestagecodegen_numOutputRows.add(1);
/* 226 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 227 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 228 */
/* 229 */       boolean agg_isNull4 = agg_aggKey.isNullAt(0);
/* 230 */       int agg_value4 = agg_isNull4 ? -1 : (agg_aggKey.getInt(0));
/* 231 */       agg_rowWriter1.zeroOutNullBytes();
/* 232 */
/* 233 */       if (agg_isNull4) {
/* 234 */         agg_rowWriter1.setNullAt(0);
/* 235 */       } else {
/* 236 */         agg_rowWriter1.write(0, agg_value4);
/* 237 */       }
/* 238 */       append(agg_result1);
/* 239 */
/* 240 */       if (shouldStop()) return;
/* 241 */     }
/* 242 */
/* 243 */     agg_mapIter.close();
/* 244 */     if (agg_sorter == null) {
/* 245 */       agg_hashMap.free();
/* 246 */     }
/* 247 */   }
/* 248 */ }
