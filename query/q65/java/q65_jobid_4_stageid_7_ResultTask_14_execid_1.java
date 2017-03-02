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
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 020 */   private UnsafeRow filter_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 027 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private UnsafeRow project_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 035 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 036 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 038 */   private UnsafeRow bhj_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 041 */   private UnsafeRow project_result2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 044 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 045 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 047 */   private UnsafeRow bhj_result2;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 050 */   private UnsafeRow project_result3;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 053 */
/* 054 */   public GeneratedIterator(Object[] references) {
/* 055 */     this.references = references;
/* 056 */   }
/* 057 */
/* 058 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 059 */     partitionIndex = index;
/* 060 */     this.inputs = inputs;
/* 061 */     wholestagecodegen_init_0();
/* 062 */     wholestagecodegen_init_1();
/* 063 */     wholestagecodegen_init_2();
/* 064 */     wholestagecodegen_init_3();
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void wholestagecodegen_init_0() {
/* 069 */     scan_input = inputs[0];
/* 070 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 071 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 072 */     scan_scanTime1 = 0;
/* 073 */     scan_batch = null;
/* 074 */     scan_batchIdx = 0;
/* 075 */     scan_colInstance0 = null;
/* 076 */     scan_colInstance1 = null;
/* 077 */     scan_result = new UnsafeRow(2);
/* 078 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 079 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 080 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 081 */     filter_result = new UnsafeRow(2);
/* 082 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 083 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 084 */     project_result = new UnsafeRow(2);
/* 085 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 086 */
/* 087 */   }
/* 088 */
/* 089 */   private void wholestagecodegen_init_3() {
/* 090 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 091 */     bhj_result2 = new UnsafeRow(9);
/* 092 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 093 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 094 */     project_result3 = new UnsafeRow(6);
/* 095 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 096 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void scan_nextBatch() throws java.io.IOException {
/* 101 */     long getBatchStart = System.nanoTime();
/* 102 */     if (scan_input.hasNext()) {
/* 103 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 104 */       scan_numOutputRows.add(scan_batch.numRows());
/* 105 */       scan_batchIdx = 0;
/* 106 */       scan_colInstance0 = scan_batch.column(0);
/* 107 */       scan_colInstance1 = scan_batch.column(1);
/* 108 */
/* 109 */     }
/* 110 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 111 */   }
/* 112 */
/* 113 */   private void wholestagecodegen_init_2() {
/* 114 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 115 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 116 */
/* 117 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 118 */     bhj_result1 = new UnsafeRow(9);
/* 119 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 120 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 121 */     project_result2 = new UnsafeRow(7);
/* 122 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 123 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 124 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 125 */
/* 126 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 127 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void wholestagecodegen_init_1() {
/* 132 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 133 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 134 */
/* 135 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 136 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 137 */
/* 138 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 139 */     bhj_result = new UnsafeRow(5);
/* 140 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 141 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 142 */     project_result1 = new UnsafeRow(4);
/* 143 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 144 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 145 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 146 */
/* 147 */   }
/* 148 */
/* 149 */   protected void processNext() throws java.io.IOException {
/* 150 */     if (scan_batch == null) {
/* 151 */       scan_nextBatch();
/* 152 */     }
/* 153 */     while (scan_batch != null) {
/* 154 */       int numRows = scan_batch.numRows();
/* 155 */       while (scan_batchIdx < numRows) {
/* 156 */         int scan_rowIdx = scan_batchIdx++;
/* 157 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 158 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 159 */
/* 160 */         if (!(!(scan_isNull))) continue;
/* 161 */
/* 162 */         filter_numOutputRows.add(1);
/* 163 */
/* 164 */         // generate join key for stream side
/* 165 */
/* 166 */         boolean bhj_isNull = false;
/* 167 */         long bhj_value = -1L;
/* 168 */         if (!false) {
/* 169 */           bhj_value = (long) scan_value;
/* 170 */         }
/* 171 */         // find matches from HashedRelation
/* 172 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 173 */         if (bhj_matched == null) continue;
/* 174 */
/* 175 */         bhj_numOutputRows.add(1);
/* 176 */
/* 177 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 178 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 179 */
/* 180 */         // generate join key for stream side
/* 181 */
/* 182 */         boolean bhj_isNull10 = bhj_isNull3;
/* 183 */         long bhj_value10 = -1L;
/* 184 */         if (!bhj_isNull3) {
/* 185 */           bhj_value10 = (long) bhj_value3;
/* 186 */         }
/* 187 */         // find matches from HashedRelation
/* 188 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 189 */         if (bhj_matched1 == null) continue;
/* 190 */
/* 191 */         bhj_numOutputRows1.add(1);
/* 192 */
/* 193 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 194 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 195 */         double bhj_value4 = bhj_matched.getDouble(2);
/* 196 */
/* 197 */         // generate join key for stream side
/* 198 */
/* 199 */         boolean bhj_isNull26 = bhj_isNull2;
/* 200 */         long bhj_value26 = -1L;
/* 201 */         if (!bhj_isNull2) {
/* 202 */           bhj_value26 = (long) bhj_value2;
/* 203 */         }
/* 204 */         // find matches from HashedRelation
/* 205 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 206 */         if (bhj_matched2 == null) continue;
/* 207 */
/* 208 */         double bhj_value29 = bhj_matched2.getDouble(1);
/* 209 */
/* 210 */         boolean bhj_isNull30 = true;
/* 211 */         boolean bhj_value30 = false;
/* 212 */
/* 213 */         if (!false) {
/* 214 */           boolean bhj_isNull32 = false;
/* 215 */
/* 216 */           double bhj_value32 = -1.0;
/* 217 */           bhj_value32 = 0.1D * bhj_value29;
/* 218 */
/* 219 */           bhj_isNull30 = false; // resultCode could change nullability.
/* 220 */           bhj_value30 = org.apache.spark.util.Utils.nanSafeCompareDoubles(bhj_value4, bhj_value32) <= 0;
/* 221 */
/* 222 */         }
/* 223 */         if (bhj_isNull30 || !bhj_value30) continue;
/* 224 */
/* 225 */         bhj_numOutputRows2.add(1);
/* 226 */
/* 227 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 228 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 229 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 230 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(1));
/* 231 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(2);
/* 232 */         double bhj_value14 = bhj_isNull14 ? -1.0 : (bhj_matched1.getDouble(2));
/* 233 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(3);
/* 234 */         double bhj_value15 = bhj_isNull15 ? -1.0 : (bhj_matched1.getDouble(3));
/* 235 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(4);
/* 236 */         UTF8String bhj_value16 = bhj_isNull16 ? null : (bhj_matched1.getUTF8String(4));
/* 237 */         project_holder3.reset();
/* 238 */
/* 239 */         project_rowWriter3.zeroOutNullBytes();
/* 240 */
/* 241 */         if (scan_isNull1) {
/* 242 */           project_rowWriter3.setNullAt(0);
/* 243 */         } else {
/* 244 */           project_rowWriter3.write(0, scan_value1);
/* 245 */         }
/* 246 */
/* 247 */         if (bhj_isNull13) {
/* 248 */           project_rowWriter3.setNullAt(1);
/* 249 */         } else {
/* 250 */           project_rowWriter3.write(1, bhj_value13);
/* 251 */         }
/* 252 */
/* 253 */         project_rowWriter3.write(2, bhj_value4);
/* 254 */
/* 255 */         if (bhj_isNull14) {
/* 256 */           project_rowWriter3.setNullAt(3);
/* 257 */         } else {
/* 258 */           project_rowWriter3.write(3, bhj_value14);
/* 259 */         }
/* 260 */
/* 261 */         if (bhj_isNull15) {
/* 262 */           project_rowWriter3.setNullAt(4);
/* 263 */         } else {
/* 264 */           project_rowWriter3.write(4, bhj_value15);
/* 265 */         }
/* 266 */
/* 267 */         if (bhj_isNull16) {
/* 268 */           project_rowWriter3.setNullAt(5);
/* 269 */         } else {
/* 270 */           project_rowWriter3.write(5, bhj_value16);
/* 271 */         }
/* 272 */         project_result3.setTotalSize(project_holder3.totalSize());
/* 273 */         append(project_result3);
/* 274 */         if (shouldStop()) return;
/* 275 */       }
/* 276 */       scan_batch = null;
/* 277 */       scan_nextBatch();
/* 278 */     }
/* 279 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 280 */     scan_scanTime1 = 0;
/* 281 */   }
/* 282 */ }
