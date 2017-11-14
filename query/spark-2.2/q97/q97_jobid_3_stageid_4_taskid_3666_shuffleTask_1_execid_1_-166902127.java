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
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */   private UnsafeRow agg_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 039 */   private int agg_value4;
/* 040 */   private UnsafeRow agg_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */     wholestagecodegen_init_2();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     agg_initAgg = false;
/* 061 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 062 */
/* 063 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 064 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 065 */     scan_input = inputs[0];
/* 066 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 067 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 068 */     scan_scanTime1 = 0;
/* 069 */     scan_batch = null;
/* 070 */     scan_batchIdx = 0;
/* 071 */     scan_colInstance0 = null;
/* 072 */     scan_colInstance1 = null;
/* 073 */     scan_colInstance2 = null;
/* 074 */     scan_result = new UnsafeRow(3);
/* 075 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 076 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 077 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 078 */
/* 079 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 080 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   private void scan_nextBatch() throws java.io.IOException {
/* 085 */     long getBatchStart = System.nanoTime();
/* 086 */     if (scan_input.hasNext()) {
/* 087 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 088 */       scan_numOutputRows.add(scan_batch.numRows());
/* 089 */       scan_batchIdx = 0;
/* 090 */       scan_colInstance0 = scan_batch.column(0);
/* 091 */       scan_colInstance1 = scan_batch.column(1);
/* 092 */       scan_colInstance2 = scan_batch.column(2);
/* 093 */
/* 094 */     }
/* 095 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 096 */   }
/* 097 */
/* 098 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 099 */     agg_hashMap = agg_plan.createHashMap();
/* 100 */
/* 101 */     if (scan_batch == null) {
/* 102 */       scan_nextBatch();
/* 103 */     }
/* 104 */     while (scan_batch != null) {
/* 105 */       int scan_numRows = scan_batch.numRows();
/* 106 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 107 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 108 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 109 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 110 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 111 */
/* 112 */         // generate join key for stream side
/* 113 */
/* 114 */         boolean bhj_isNull = scan_isNull2;
/* 115 */         long bhj_value = -1L;
/* 116 */         if (!scan_isNull2) {
/* 117 */           bhj_value = (long) scan_value2;
/* 118 */         }
/* 119 */         // find matches from HashedRelation
/* 120 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 121 */         if (bhj_matched == null) continue;
/* 122 */
/* 123 */         bhj_numOutputRows.add(1);
/* 124 */
/* 125 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 126 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 127 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 128 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 129 */
/* 130 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 131 */
/* 132 */         UnsafeRow agg_fastAggBuffer = null;
/* 133 */
/* 134 */         if (agg_fastAggBuffer == null) {
/* 135 */           // generate grouping key
/* 136 */           agg_rowWriter.zeroOutNullBytes();
/* 137 */
/* 138 */           if (scan_isNull) {
/* 139 */             agg_rowWriter.setNullAt(0);
/* 140 */           } else {
/* 141 */             agg_rowWriter.write(0, scan_value);
/* 142 */           }
/* 143 */
/* 144 */           if (scan_isNull1) {
/* 145 */             agg_rowWriter.setNullAt(1);
/* 146 */           } else {
/* 147 */             agg_rowWriter.write(1, scan_value1);
/* 148 */           }
/* 149 */           agg_value4 = 42;
/* 150 */
/* 151 */           if (!scan_isNull) {
/* 152 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value4);
/* 153 */           }
/* 154 */
/* 155 */           if (!scan_isNull1) {
/* 156 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value1, agg_value4);
/* 157 */           }
/* 158 */           if (true) {
/* 159 */             // try to get the buffer from hash map
/* 160 */             agg_unsafeRowAggBuffer =
/* 161 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 162 */           }
/* 163 */           if (agg_unsafeRowAggBuffer == null) {
/* 164 */             if (agg_sorter == null) {
/* 165 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 166 */             } else {
/* 167 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 168 */             }
/* 169 */
/* 170 */             // the hash map had be spilled, it should have enough memory now,
/* 171 */             // try  to allocate buffer again.
/* 172 */             agg_unsafeRowAggBuffer =
/* 173 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 174 */             if (agg_unsafeRowAggBuffer == null) {
/* 175 */               // failed to allocate the first page
/* 176 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 177 */             }
/* 178 */           }
/* 179 */         }
/* 180 */
/* 181 */         if (agg_fastAggBuffer != null) {
/* 182 */           // update fast row
/* 183 */
/* 184 */         } else {
/* 185 */           // update unsafe row
/* 186 */
/* 187 */           // common sub-expressions
/* 188 */
/* 189 */           // evaluate aggregate function
/* 190 */
/* 191 */           // update unsafe row buffer
/* 192 */
/* 193 */         }
/* 194 */         // shouldStop check is eliminated
/* 195 */       }
/* 196 */       scan_batchIdx = scan_numRows;
/* 197 */       scan_batch = null;
/* 198 */       scan_nextBatch();
/* 199 */     }
/* 200 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 201 */     scan_scanTime1 = 0;
/* 202 */
/* 203 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 204 */   }
/* 205 */
/* 206 */   private void wholestagecodegen_init_2() {
/* 207 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 208 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 209 */
/* 210 */   }
/* 211 */
/* 212 */   private void wholestagecodegen_init_1() {
/* 213 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 214 */     bhj_result = new UnsafeRow(4);
/* 215 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 216 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 217 */     project_result = new UnsafeRow(2);
/* 218 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 219 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 220 */     agg_result = new UnsafeRow(2);
/* 221 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 222 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 223 */
/* 224 */     agg_result1 = new UnsafeRow(2);
/* 225 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 226 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 227 */
/* 228 */   }
/* 229 */
/* 230 */   protected void processNext() throws java.io.IOException {
/* 231 */     if (!agg_initAgg) {
/* 232 */       agg_initAgg = true;
/* 233 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 234 */       agg_doAggregateWithKeys();
/* 235 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 236 */     }
/* 237 */
/* 238 */     // output the result
/* 239 */
/* 240 */     while (agg_mapIter.next()) {
/* 241 */       wholestagecodegen_numOutputRows.add(1);
/* 242 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 243 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 244 */
/* 245 */       boolean agg_isNull7 = agg_aggKey.isNullAt(0);
/* 246 */       int agg_value7 = agg_isNull7 ? -1 : (agg_aggKey.getInt(0));
/* 247 */       boolean agg_isNull8 = agg_aggKey.isNullAt(1);
/* 248 */       int agg_value8 = agg_isNull8 ? -1 : (agg_aggKey.getInt(1));
/* 249 */       agg_rowWriter1.zeroOutNullBytes();
/* 250 */
/* 251 */       if (agg_isNull7) {
/* 252 */         agg_rowWriter1.setNullAt(0);
/* 253 */       } else {
/* 254 */         agg_rowWriter1.write(0, agg_value7);
/* 255 */       }
/* 256 */
/* 257 */       if (agg_isNull8) {
/* 258 */         agg_rowWriter1.setNullAt(1);
/* 259 */       } else {
/* 260 */         agg_rowWriter1.write(1, agg_value8);
/* 261 */       }
/* 262 */       append(agg_result1);
/* 263 */
/* 264 */       if (shouldStop()) return;
/* 265 */     }
/* 266 */
/* 267 */     agg_mapIter.close();
/* 268 */     if (agg_sorter == null) {
/* 269 */       agg_hashMap.free();
/* 270 */     }
/* 271 */   }
/* 272 */ }
