/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean sort_needToSort;
/* 009 */   private org.apache.spark.sql.execution.SortExec sort_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeExternalRowSorter sort_sorter;
/* 011 */   private org.apache.spark.executor.TaskMetrics sort_metrics;
/* 012 */   private scala.collection.Iterator<UnsafeRow> sort_sortedIter;
/* 013 */   private boolean agg_initAgg;
/* 014 */   private boolean agg_bufIsNull;
/* 015 */   private double agg_bufValue;
/* 016 */   private boolean agg_bufIsNull1;
/* 017 */   private long agg_bufValue1;
/* 018 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 019 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 020 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 021 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 024 */   private scala.collection.Iterator inputadapter_input;
/* 025 */   private UnsafeRow agg_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 028 */   private int agg_value7;
/* 029 */   private UnsafeRow agg_result1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 033 */   private UnsafeRow filter_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_numOutputRows;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_aggTime;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     wholestagecodegen_init_0();
/* 050 */     wholestagecodegen_init_1();
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void wholestagecodegen_init_0() {
/* 055 */     sort_needToSort = true;
/* 056 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 057 */     sort_sorter = sort_plan.createSorter();
/* 058 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 059 */
/* 060 */     agg_initAgg = false;
/* 061 */
/* 062 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[1];
/* 063 */
/* 064 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 065 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 066 */     inputadapter_input = inputs[0];
/* 067 */     agg_result = new UnsafeRow(1);
/* 068 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 069 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 070 */
/* 071 */     agg_result1 = new UnsafeRow(2);
/* 072 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 073 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 074 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 079 */     agg_hashMap = agg_plan.createHashMap();
/* 080 */
/* 081 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 082 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 083 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 084 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 085 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 086 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 087 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 088 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 089 */
/* 090 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 091 */
/* 092 */       UnsafeRow agg_fastAggBuffer = null;
/* 093 */
/* 094 */       if (agg_fastAggBuffer == null) {
/* 095 */         // generate grouping key
/* 096 */         agg_rowWriter.zeroOutNullBytes();
/* 097 */
/* 098 */         if (inputadapter_isNull) {
/* 099 */           agg_rowWriter.setNullAt(0);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(0, inputadapter_value);
/* 102 */         }
/* 103 */         agg_value7 = 42;
/* 104 */
/* 105 */         if (!inputadapter_isNull) {
/* 106 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value7);
/* 107 */         }
/* 108 */         if (true) {
/* 109 */           // try to get the buffer from hash map
/* 110 */           agg_unsafeRowAggBuffer =
/* 111 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 112 */         }
/* 113 */         if (agg_unsafeRowAggBuffer == null) {
/* 114 */           if (agg_sorter == null) {
/* 115 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 116 */           } else {
/* 117 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 118 */           }
/* 119 */
/* 120 */           // the hash map had be spilled, it should have enough memory now,
/* 121 */           // try  to allocate buffer again.
/* 122 */           agg_unsafeRowAggBuffer =
/* 123 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 124 */           if (agg_unsafeRowAggBuffer == null) {
/* 125 */             // failed to allocate the first page
/* 126 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 127 */           }
/* 128 */         }
/* 129 */       }
/* 130 */
/* 131 */       if (agg_fastAggBuffer != null) {
/* 132 */         // update fast row
/* 133 */
/* 134 */       } else {
/* 135 */         // update unsafe row
/* 136 */
/* 137 */         // common sub-expressions
/* 138 */
/* 139 */         // evaluate aggregate function
/* 140 */         boolean agg_isNull7 = true;
/* 141 */         double agg_value9 = -1.0;
/* 142 */
/* 143 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 144 */         double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 145 */         if (!agg_isNull8) {
/* 146 */           if (!inputadapter_isNull1) {
/* 147 */             agg_isNull7 = false; // resultCode could change nullability.
/* 148 */             agg_value9 = agg_value10 + inputadapter_value1;
/* 149 */
/* 150 */           }
/* 151 */
/* 152 */         }
/* 153 */         boolean agg_isNull10 = true;
/* 154 */         long agg_value12 = -1L;
/* 155 */
/* 156 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 157 */         long agg_value13 = agg_isNull11 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 158 */         if (!agg_isNull11) {
/* 159 */           if (!inputadapter_isNull2) {
/* 160 */             agg_isNull10 = false; // resultCode could change nullability.
/* 161 */             agg_value12 = agg_value13 + inputadapter_value2;
/* 162 */
/* 163 */           }
/* 164 */
/* 165 */         }
/* 166 */         // update unsafe row buffer
/* 167 */         if (!agg_isNull7) {
/* 168 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 169 */         } else {
/* 170 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 171 */         }
/* 172 */
/* 173 */         if (!agg_isNull10) {
/* 174 */           agg_unsafeRowAggBuffer.setLong(1, agg_value12);
/* 175 */         } else {
/* 176 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 177 */         }
/* 178 */
/* 179 */       }
/* 180 */       if (shouldStop()) return;
/* 181 */     }
/* 182 */
/* 183 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 184 */   }
/* 185 */
/* 186 */   private void wholestagecodegen_init_1() {
/* 187 */     filter_result = new UnsafeRow(2);
/* 188 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 189 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 190 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 191 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 192 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 193 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 194 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 195 */
/* 196 */   }
/* 197 */
/* 198 */   private void sort_addToSorter() throws java.io.IOException {
/* 199 */     if (!agg_initAgg) {
/* 200 */       agg_initAgg = true;
/* 201 */       long sort_beforeAgg = System.nanoTime();
/* 202 */       agg_doAggregateWithKeys();
/* 203 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 204 */     }
/* 205 */
/* 206 */     // output the result
/* 207 */
/* 208 */     while (agg_mapIter.next()) {
/* 209 */       sort_numOutputRows.add(1);
/* 210 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 211 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 212 */
/* 213 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 214 */       int agg_value15 = agg_isNull13 ? -1 : (agg_aggKey.getInt(0));
/* 215 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 216 */       double agg_value16 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 217 */       boolean agg_isNull15 = agg_aggBuffer.isNullAt(1);
/* 218 */       long agg_value17 = agg_isNull15 ? -1L : (agg_aggBuffer.getLong(1));
/* 219 */       boolean agg_isNull18 = agg_isNull15;
/* 220 */       double agg_value20 = -1.0;
/* 221 */       if (!agg_isNull15) {
/* 222 */         agg_value20 = (double) agg_value17;
/* 223 */       }
/* 224 */       boolean agg_isNull16 = false;
/* 225 */       double agg_value18 = -1.0;
/* 226 */       if (agg_isNull18 || agg_value20 == 0) {
/* 227 */         agg_isNull16 = true;
/* 228 */       } else {
/* 229 */         if (agg_isNull14) {
/* 230 */           agg_isNull16 = true;
/* 231 */         } else {
/* 232 */           agg_value18 = (double)(agg_value16 / agg_value20);
/* 233 */         }
/* 234 */       }
/* 235 */
/* 236 */       if (!(!(agg_isNull16))) continue;
/* 237 */
/* 238 */       filter_numOutputRows.add(1);
/* 239 */
/* 240 */       filter_rowWriter.zeroOutNullBytes();
/* 241 */
/* 242 */       if (agg_isNull13) {
/* 243 */         filter_rowWriter.setNullAt(0);
/* 244 */       } else {
/* 245 */         filter_rowWriter.write(0, agg_value15);
/* 246 */       }
/* 247 */
/* 248 */       filter_rowWriter.write(1, agg_value18);
/* 249 */       sort_sorter.insertRow((UnsafeRow)filter_result);
/* 250 */
/* 251 */       if (shouldStop()) return;
/* 252 */     }
/* 253 */
/* 254 */     agg_mapIter.close();
/* 255 */     if (agg_sorter == null) {
/* 256 */       agg_hashMap.free();
/* 257 */     }
/* 258 */
/* 259 */   }
/* 260 */
/* 261 */   protected void processNext() throws java.io.IOException {
/* 262 */     if (sort_needToSort) {
/* 263 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 264 */       sort_addToSorter();
/* 265 */       sort_sortedIter = sort_sorter.sort();
/* 266 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 267 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 268 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 269 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 270 */       sort_needToSort = false;
/* 271 */     }
/* 272 */
/* 273 */     while (sort_sortedIter.hasNext()) {
/* 274 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 275 */
/* 276 */       append(sort_outputRow);
/* 277 */
/* 278 */       if (shouldStop()) return;
/* 279 */     }
/* 280 */   }
/* 281 */ }
