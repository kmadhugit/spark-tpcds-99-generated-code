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
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 021 */   private UnsafeRow scan_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 025 */   private UnsafeRow filter_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 028 */   private UnsafeRow project_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 031 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 032 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 034 */   private UnsafeRow bhj_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 037 */   private UnsafeRow project_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 040 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 041 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 043 */   private UnsafeRow bhj_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 046 */   private UnsafeRow project_result2;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 052 */   private UnsafeRow bhj_result2;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 055 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 057 */   private UnsafeRow agg_result;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 060 */
/* 061 */   public GeneratedIterator(Object[] references) {
/* 062 */     this.references = references;
/* 063 */   }
/* 064 */
/* 065 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 066 */     partitionIndex = index;
/* 067 */     this.inputs = inputs;
/* 068 */     wholestagecodegen_init_0();
/* 069 */     wholestagecodegen_init_1();
/* 070 */     wholestagecodegen_init_2();
/* 071 */     wholestagecodegen_init_3();
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */   private void wholestagecodegen_init_0() {
/* 076 */     agg_initAgg = false;
/* 077 */
/* 078 */     scan_input = inputs[0];
/* 079 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 080 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 081 */     scan_scanTime1 = 0;
/* 082 */     scan_batch = null;
/* 083 */     scan_batchIdx = 0;
/* 084 */     scan_colInstance0 = null;
/* 085 */     scan_colInstance1 = null;
/* 086 */     scan_colInstance2 = null;
/* 087 */     scan_colInstance3 = null;
/* 088 */     scan_result = new UnsafeRow(4);
/* 089 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 090 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 091 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 092 */     filter_result = new UnsafeRow(4);
/* 093 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 094 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 095 */     project_result = new UnsafeRow(3);
/* 096 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 101 */     // initialize aggregation buffer
/* 102 */     agg_bufIsNull = false;
/* 103 */     agg_bufValue = 0L;
/* 104 */
/* 105 */     if (scan_batch == null) {
/* 106 */       scan_nextBatch();
/* 107 */     }
/* 108 */     while (scan_batch != null) {
/* 109 */       int scan_numRows = scan_batch.numRows();
/* 110 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 111 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 112 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 113 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 114 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 115 */
/* 116 */         if (!(!(scan_isNull1))) continue;
/* 117 */
/* 118 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 119 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 120 */
/* 121 */         if (!(!(scan_isNull))) continue;
/* 122 */
/* 123 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 124 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 125 */
/* 126 */         if (!(!(scan_isNull2))) continue;
/* 127 */
/* 128 */         filter_numOutputRows.add(1);
/* 129 */
/* 130 */         // generate join key for stream side
/* 131 */
/* 132 */         boolean bhj_isNull = false;
/* 133 */         long bhj_value = -1L;
/* 134 */         if (!false) {
/* 135 */           bhj_value = (long) scan_value1;
/* 136 */         }
/* 137 */         // find matches from HashedRelation
/* 138 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 139 */         if (bhj_matched == null) continue;
/* 140 */
/* 141 */         bhj_numOutputRows.add(1);
/* 142 */
/* 143 */         // generate join key for stream side
/* 144 */
/* 145 */         boolean bhj_isNull7 = false;
/* 146 */         long bhj_value7 = -1L;
/* 147 */         if (!false) {
/* 148 */           bhj_value7 = (long) scan_value;
/* 149 */         }
/* 150 */         // find matches from HashedRelation
/* 151 */         UnsafeRow bhj_matched1 = bhj_isNull7 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value7);
/* 152 */         if (bhj_matched1 == null) continue;
/* 153 */
/* 154 */         bhj_numOutputRows1.add(1);
/* 155 */
/* 156 */         // generate join key for stream side
/* 157 */
/* 158 */         boolean bhj_isNull13 = false;
/* 159 */         long bhj_value13 = -1L;
/* 160 */         if (!false) {
/* 161 */           bhj_value13 = (long) scan_value2;
/* 162 */         }
/* 163 */         // find matches from HashedRelation
/* 164 */         UnsafeRow bhj_matched2 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value13);
/* 165 */         if (bhj_matched2 == null) continue;
/* 166 */
/* 167 */         bhj_numOutputRows2.add(1);
/* 168 */
/* 169 */         // do aggregate
/* 170 */         // common sub-expressions
/* 171 */
/* 172 */         // evaluate aggregate function
/* 173 */         boolean agg_isNull1 = false;
/* 174 */
/* 175 */         long agg_value1 = -1L;
/* 176 */         agg_value1 = agg_bufValue + 1L;
/* 177 */         // update aggregation buffer
/* 178 */         agg_bufIsNull = false;
/* 179 */         agg_bufValue = agg_value1;
/* 180 */         // shouldStop check is eliminated
/* 181 */       }
/* 182 */       scan_batchIdx = scan_numRows;
/* 183 */       scan_batch = null;
/* 184 */       scan_nextBatch();
/* 185 */     }
/* 186 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 187 */     scan_scanTime1 = 0;
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */   private void wholestagecodegen_init_3() {
/* 192 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 193 */     bhj_result2 = new UnsafeRow(2);
/* 194 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 195 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 2);
/* 196 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 197 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 198 */     agg_result = new UnsafeRow(1);
/* 199 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 200 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 201 */
/* 202 */   }
/* 203 */
/* 204 */   private void scan_nextBatch() throws java.io.IOException {
/* 205 */     long getBatchStart = System.nanoTime();
/* 206 */     if (scan_input.hasNext()) {
/* 207 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 208 */       scan_numOutputRows.add(scan_batch.numRows());
/* 209 */       scan_batchIdx = 0;
/* 210 */       scan_colInstance0 = scan_batch.column(0);
/* 211 */       scan_colInstance1 = scan_batch.column(1);
/* 212 */       scan_colInstance2 = scan_batch.column(2);
/* 213 */       scan_colInstance3 = scan_batch.column(3);
/* 214 */
/* 215 */     }
/* 216 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 217 */   }
/* 218 */
/* 219 */   private void wholestagecodegen_init_2() {
/* 220 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 221 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 222 */
/* 223 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 224 */     bhj_result1 = new UnsafeRow(3);
/* 225 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 226 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 3);
/* 227 */     project_result2 = new UnsafeRow(1);
/* 228 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 229 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 1);
/* 230 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 231 */
/* 232 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 233 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 234 */
/* 235 */   }
/* 236 */
/* 237 */   private void wholestagecodegen_init_1() {
/* 238 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 239 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 240 */
/* 241 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 242 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 243 */
/* 244 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 245 */     bhj_result = new UnsafeRow(4);
/* 246 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 247 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 248 */     project_result1 = new UnsafeRow(2);
/* 249 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 250 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 251 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 252 */
/* 253 */   }
/* 254 */
/* 255 */   protected void processNext() throws java.io.IOException {
/* 256 */     while (!agg_initAgg) {
/* 257 */       agg_initAgg = true;
/* 258 */       long agg_beforeAgg = System.nanoTime();
/* 259 */       agg_doAggregateWithoutKey();
/* 260 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 261 */
/* 262 */       // output the result
/* 263 */
/* 264 */       agg_numOutputRows.add(1);
/* 265 */       agg_rowWriter.zeroOutNullBytes();
/* 266 */
/* 267 */       if (agg_bufIsNull) {
/* 268 */         agg_rowWriter.setNullAt(0);
/* 269 */       } else {
/* 270 */         agg_rowWriter.write(0, agg_bufValue);
/* 271 */       }
/* 272 */       append(agg_result);
/* 273 */     }
/* 274 */   }
/* 275 */ }
