/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private UnsafeRow scan_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 024 */   private UnsafeRow filter_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 027 */   private UnsafeRow project_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 030 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 031 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 033 */   private UnsafeRow bhj_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 036 */   private UnsafeRow project_result1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 039 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 040 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 042 */   private UnsafeRow bhj_result1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 045 */   private UnsafeRow project_result2;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 051 */   private UnsafeRow bhj_result2;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 054 */   private UnsafeRow project_result3;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 060 */   private UnsafeRow bhj_result3;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 063 */   private UnsafeRow project_result4;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 066 */
/* 067 */   public GeneratedIterator(Object[] references) {
/* 068 */     this.references = references;
/* 069 */   }
/* 070 */
/* 071 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 072 */     partitionIndex = index;
/* 073 */     this.inputs = inputs;
/* 074 */     wholestagecodegen_init_0();
/* 075 */     wholestagecodegen_init_1();
/* 076 */     wholestagecodegen_init_2();
/* 077 */     wholestagecodegen_init_3();
/* 078 */     wholestagecodegen_init_4();
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_0() {
/* 083 */     scan_input = inputs[0];
/* 084 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 085 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     scan_scanTime1 = 0;
/* 087 */     scan_batch = null;
/* 088 */     scan_batchIdx = 0;
/* 089 */     scan_colInstance0 = null;
/* 090 */     scan_colInstance1 = null;
/* 091 */     scan_colInstance2 = null;
/* 092 */     scan_colInstance3 = null;
/* 093 */     scan_colInstance4 = null;
/* 094 */     scan_colInstance5 = null;
/* 095 */     scan_result = new UnsafeRow(6);
/* 096 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 097 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 6);
/* 098 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 099 */     filter_result = new UnsafeRow(6);
/* 100 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 101 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 6);
/* 102 */     project_result = new UnsafeRow(6);
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   private void wholestagecodegen_init_3() {
/* 107 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 108 */     bhj_result2 = new UnsafeRow(7);
/* 109 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 110 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 111 */     project_result3 = new UnsafeRow(5);
/* 112 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 113 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 114 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 115 */
/* 116 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 117 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 118 */
/* 119 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 120 */     bhj_result3 = new UnsafeRow(6);
/* 121 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 96);
/* 122 */
/* 123 */   }
/* 124 */
/* 125 */   private void scan_nextBatch() throws java.io.IOException {
/* 126 */     long getBatchStart = System.nanoTime();
/* 127 */     if (scan_input.hasNext()) {
/* 128 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 129 */       scan_numOutputRows.add(scan_batch.numRows());
/* 130 */       scan_batchIdx = 0;
/* 131 */       scan_colInstance0 = scan_batch.column(0);
/* 132 */       scan_colInstance1 = scan_batch.column(1);
/* 133 */       scan_colInstance2 = scan_batch.column(2);
/* 134 */       scan_colInstance3 = scan_batch.column(3);
/* 135 */       scan_colInstance4 = scan_batch.column(4);
/* 136 */       scan_colInstance5 = scan_batch.column(5);
/* 137 */
/* 138 */     }
/* 139 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 140 */   }
/* 141 */
/* 142 */   private void wholestagecodegen_init_2() {
/* 143 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 144 */
/* 145 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 146 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 147 */
/* 148 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 149 */     bhj_result1 = new UnsafeRow(6);
/* 150 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 151 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 152 */     project_result2 = new UnsafeRow(5);
/* 153 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 154 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 155 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 156 */
/* 157 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 158 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 159 */
/* 160 */   }
/* 161 */
/* 162 */   private void wholestagecodegen_init_1() {
/* 163 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 164 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 165 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 166 */
/* 167 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 168 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 169 */
/* 170 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 171 */     bhj_result = new UnsafeRow(7);
/* 172 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 173 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 174 */     project_result1 = new UnsafeRow(5);
/* 175 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 176 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 177 */
/* 178 */   }
/* 179 */
/* 180 */   private void wholestagecodegen_init_4() {
/* 181 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 6);
/* 182 */     project_result4 = new UnsafeRow(4);
/* 183 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 96);
/* 184 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 4);
/* 185 */
/* 186 */   }
/* 187 */
/* 188 */   protected void processNext() throws java.io.IOException {
/* 189 */     if (scan_batch == null) {
/* 190 */       scan_nextBatch();
/* 191 */     }
/* 192 */     while (scan_batch != null) {
/* 193 */       int numRows = scan_batch.numRows();
/* 194 */       while (scan_batchIdx < numRows) {
/* 195 */         int scan_rowIdx = scan_batchIdx++;
/* 196 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 197 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 198 */
/* 199 */         if (!(!(scan_isNull3))) continue;
/* 200 */
/* 201 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 202 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 203 */
/* 204 */         if (!(!(scan_isNull1))) continue;
/* 205 */
/* 206 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 207 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 208 */
/* 209 */         if (!(!(scan_isNull2))) continue;
/* 210 */
/* 211 */         filter_numOutputRows.add(1);
/* 212 */
/* 213 */         // generate join key for stream side
/* 214 */
/* 215 */         boolean bhj_isNull = false;
/* 216 */         long bhj_value = -1L;
/* 217 */         if (!false) {
/* 218 */           bhj_value = (long) scan_value3;
/* 219 */         }
/* 220 */         // find matches from HashedRelation
/* 221 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 222 */         if (bhj_matched == null) continue;
/* 223 */
/* 224 */         bhj_numOutputRows.add(1);
/* 225 */
/* 226 */         // generate join key for stream side
/* 227 */
/* 228 */         boolean bhj_isNull10 = false;
/* 229 */         long bhj_value10 = -1L;
/* 230 */         if (!false) {
/* 231 */           bhj_value10 = (long) scan_value1;
/* 232 */         }
/* 233 */         // find matches from HashedRelation
/* 234 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 235 */         if (bhj_matched1 == null) continue;
/* 236 */
/* 237 */         bhj_numOutputRows1.add(1);
/* 238 */
/* 239 */         // generate join key for stream side
/* 240 */
/* 241 */         boolean bhj_isNull19 = false;
/* 242 */         long bhj_value19 = -1L;
/* 243 */         if (!false) {
/* 244 */           bhj_value19 = (long) scan_value2;
/* 245 */         }
/* 246 */         // find matches from HashedRelation
/* 247 */         UnsafeRow bhj_matched2 = bhj_isNull19 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value19);
/* 248 */         if (bhj_matched2 == null) continue;
/* 249 */
/* 250 */         bhj_numOutputRows2.add(1);
/* 251 */
/* 252 */         boolean bhj_isNull22 = bhj_matched2.isNullAt(1);
/* 253 */         int bhj_value22 = bhj_isNull22 ? -1 : (bhj_matched2.getInt(1));
/* 254 */
/* 255 */         // generate join key for stream side
/* 256 */
/* 257 */         boolean bhj_isNull30 = bhj_isNull22;
/* 258 */         long bhj_value30 = -1L;
/* 259 */         if (!bhj_isNull22) {
/* 260 */           bhj_value30 = (long) bhj_value22;
/* 261 */         }
/* 262 */         // find matches from HashedRelation
/* 263 */         UnsafeRow bhj_matched3 = bhj_isNull30 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value30);
/* 264 */         if (bhj_matched3 == null) continue;
/* 265 */
/* 266 */         bhj_numOutputRows3.add(1);
/* 267 */
/* 268 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 269 */         UTF8String scan_value = scan_isNull ? null : (scan_colInstance0.getUTF8String(scan_rowIdx));
/* 270 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 271 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 272 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 273 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 274 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(0);
/* 275 */         int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched1.getInt(0));
/* 276 */         project_holder4.reset();
/* 277 */
/* 278 */         project_rowWriter4.zeroOutNullBytes();
/* 279 */
/* 280 */         if (scan_isNull) {
/* 281 */           project_rowWriter4.setNullAt(0);
/* 282 */         } else {
/* 283 */           project_rowWriter4.write(0, scan_value);
/* 284 */         }
/* 285 */
/* 286 */         if (scan_isNull4) {
/* 287 */           project_rowWriter4.setNullAt(1);
/* 288 */         } else {
/* 289 */           project_rowWriter4.write(1, scan_value4);
/* 290 */         }
/* 291 */
/* 292 */         if (scan_isNull5) {
/* 293 */           project_rowWriter4.setNullAt(2);
/* 294 */         } else {
/* 295 */           project_rowWriter4.write(2, scan_value5);
/* 296 */         }
/* 297 */
/* 298 */         if (bhj_isNull12) {
/* 299 */           project_rowWriter4.setNullAt(3);
/* 300 */         } else {
/* 301 */           project_rowWriter4.write(3, bhj_value12);
/* 302 */         }
/* 303 */         project_result4.setTotalSize(project_holder4.totalSize());
/* 304 */         append(project_result4);
/* 305 */         if (shouldStop()) return;
/* 306 */       }
/* 307 */       scan_batch = null;
/* 308 */       scan_nextBatch();
/* 309 */     }
/* 310 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 311 */     scan_scanTime1 = 0;
/* 312 */   }
/* 313 */ }
