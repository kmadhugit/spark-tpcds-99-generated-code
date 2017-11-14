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
/* 113 */         filter_value2 = scan_value1 == 1998;
/* 114 */         if (!filter_value2) continue;
/* 115 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 116 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 117 */
/* 118 */         if (!(!(scan_isNull2))) continue;
/* 119 */
/* 120 */         boolean filter_isNull7 = false;
/* 121 */
/* 122 */         boolean filter_value7 = false;
/* 123 */         filter_value7 = scan_value2 == 12;
/* 124 */         if (!filter_value7) continue;
/* 125 */
/* 126 */         filter_numOutputRows.add(1);
/* 127 */
/* 128 */         boolean project_isNull = true;
/* 129 */         int project_value = -1;
/* 130 */
/* 131 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 132 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 133 */         if (!scan_isNull) {
/* 134 */           project_isNull = false; // resultCode could change nullability.
/* 135 */           project_value = scan_value + 1;
/* 136 */
/* 137 */         }
/* 138 */
/* 139 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 140 */
/* 141 */         UnsafeRow agg_fastAggBuffer = null;
/* 142 */
/* 143 */         if (agg_fastAggBuffer == null) {
/* 144 */           // generate grouping key
/* 145 */           agg_rowWriter.zeroOutNullBytes();
/* 146 */
/* 147 */           if (project_isNull) {
/* 148 */             agg_rowWriter.setNullAt(0);
/* 149 */           } else {
/* 150 */             agg_rowWriter.write(0, project_value);
/* 151 */           }
/* 152 */           agg_value2 = 42;
/* 153 */
/* 154 */           if (!project_isNull) {
/* 155 */             agg_value2 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(project_value, agg_value2);
/* 156 */           }
/* 157 */           if (true) {
/* 158 */             // try to get the buffer from hash map
/* 159 */             agg_unsafeRowAggBuffer =
/* 160 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 161 */           }
/* 162 */           if (agg_unsafeRowAggBuffer == null) {
/* 163 */             if (agg_sorter == null) {
/* 164 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 165 */             } else {
/* 166 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 167 */             }
/* 168 */
/* 169 */             // the hash map had be spilled, it should have enough memory now,
/* 170 */             // try  to allocate buffer again.
/* 171 */             agg_unsafeRowAggBuffer =
/* 172 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 173 */             if (agg_unsafeRowAggBuffer == null) {
/* 174 */               // failed to allocate the first page
/* 175 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 176 */             }
/* 177 */           }
/* 178 */         }
/* 179 */
/* 180 */         if (agg_fastAggBuffer != null) {
/* 181 */           // update fast row
/* 182 */
/* 183 */         } else {
/* 184 */           // update unsafe row
/* 185 */
/* 186 */           // common sub-expressions
/* 187 */
/* 188 */           // evaluate aggregate function
/* 189 */
/* 190 */           // update unsafe row buffer
/* 191 */
/* 192 */         }
/* 193 */         // shouldStop check is eliminated
/* 194 */       }
/* 195 */       scan_batchIdx = scan_numRows;
/* 196 */       scan_batch = null;
/* 197 */       scan_nextBatch();
/* 198 */     }
/* 199 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 200 */     scan_scanTime1 = 0;
/* 201 */
/* 202 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 203 */   }
/* 204 */
/* 205 */   private void wholestagecodegen_init_1() {
/* 206 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 207 */     project_result = new UnsafeRow(1);
/* 208 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 209 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 210 */     agg_result = new UnsafeRow(1);
/* 211 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 212 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 213 */
/* 214 */     agg_result1 = new UnsafeRow(1);
/* 215 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 216 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 217 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 218 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 219 */
/* 220 */   }
/* 221 */
/* 222 */   protected void processNext() throws java.io.IOException {
/* 223 */     if (!agg_initAgg) {
/* 224 */       agg_initAgg = true;
/* 225 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 226 */       agg_doAggregateWithKeys();
/* 227 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 228 */     }
/* 229 */
/* 230 */     // output the result
/* 231 */
/* 232 */     while (agg_mapIter.next()) {
/* 233 */       wholestagecodegen_numOutputRows.add(1);
/* 234 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 235 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 236 */
/* 237 */       boolean agg_isNull4 = agg_aggKey.isNullAt(0);
/* 238 */       int agg_value4 = agg_isNull4 ? -1 : (agg_aggKey.getInt(0));
/* 239 */       agg_rowWriter1.zeroOutNullBytes();
/* 240 */
/* 241 */       if (agg_isNull4) {
/* 242 */         agg_rowWriter1.setNullAt(0);
/* 243 */       } else {
/* 244 */         agg_rowWriter1.write(0, agg_value4);
/* 245 */       }
/* 246 */       append(agg_result1);
/* 247 */
/* 248 */       if (shouldStop()) return;
/* 249 */     }
/* 250 */
/* 251 */     agg_mapIter.close();
/* 252 */     if (agg_sorter == null) {
/* 253 */       agg_hashMap.free();
/* 254 */     }
/* 255 */   }
/* 256 */ }
