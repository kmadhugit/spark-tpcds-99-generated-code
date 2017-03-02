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
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance24;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance25;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance26;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance27;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance28;
/* 043 */   private UnsafeRow scan_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 047 */   private UnsafeRow filter_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 050 */   private UnsafeRow project_result;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 053 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 054 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 055 */   private UnsafeRow bhj_result;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 059 */   private UnsafeRow bhj_result1;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 062 */   private UnsafeRow project_result1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 065 */
/* 066 */   public GeneratedIterator(Object[] references) {
/* 067 */     this.references = references;
/* 068 */   }
/* 069 */
/* 070 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 071 */     partitionIndex = index;
/* 072 */     this.inputs = inputs;
/* 073 */     wholestagecodegen_init_0();
/* 074 */     wholestagecodegen_init_1();
/* 075 */     wholestagecodegen_init_2();
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_0() {
/* 080 */     scan_input = inputs[0];
/* 081 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 082 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 083 */     scan_scanTime1 = 0;
/* 084 */     scan_batch = null;
/* 085 */     scan_batchIdx = 0;
/* 086 */     scan_colInstance0 = null;
/* 087 */     scan_colInstance1 = null;
/* 088 */     scan_colInstance2 = null;
/* 089 */     scan_colInstance3 = null;
/* 090 */     scan_colInstance4 = null;
/* 091 */     scan_colInstance5 = null;
/* 092 */     scan_colInstance6 = null;
/* 093 */     scan_colInstance7 = null;
/* 094 */     scan_colInstance8 = null;
/* 095 */     scan_colInstance9 = null;
/* 096 */     scan_colInstance10 = null;
/* 097 */     scan_colInstance11 = null;
/* 098 */     scan_colInstance12 = null;
/* 099 */     scan_colInstance13 = null;
/* 100 */     scan_colInstance14 = null;
/* 101 */     scan_colInstance15 = null;
/* 102 */     scan_colInstance16 = null;
/* 103 */     scan_colInstance17 = null;
/* 104 */     scan_colInstance18 = null;
/* 105 */     scan_colInstance19 = null;
/* 106 */     scan_colInstance20 = null;
/* 107 */     scan_colInstance21 = null;
/* 108 */     scan_colInstance22 = null;
/* 109 */     scan_colInstance23 = null;
/* 110 */     scan_colInstance24 = null;
/* 111 */     scan_colInstance25 = null;
/* 112 */     scan_colInstance26 = null;
/* 113 */     scan_colInstance27 = null;
/* 114 */     scan_colInstance28 = null;
/* 115 */
/* 116 */   }
/* 117 */
/* 118 */   private void scan_nextBatch() throws java.io.IOException {
/* 119 */     long getBatchStart = System.nanoTime();
/* 120 */     if (scan_input.hasNext()) {
/* 121 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 122 */       scan_numOutputRows.add(scan_batch.numRows());
/* 123 */       scan_batchIdx = 0;
/* 124 */       scan_colInstance0 = scan_batch.column(0);
/* 125 */       scan_colInstance1 = scan_batch.column(1);
/* 126 */       scan_colInstance2 = scan_batch.column(2);
/* 127 */       scan_colInstance3 = scan_batch.column(3);
/* 128 */       scan_colInstance4 = scan_batch.column(4);
/* 129 */       scan_colInstance5 = scan_batch.column(5);
/* 130 */       scan_colInstance6 = scan_batch.column(6);
/* 131 */       scan_colInstance7 = scan_batch.column(7);
/* 132 */       scan_colInstance8 = scan_batch.column(8);
/* 133 */       scan_colInstance9 = scan_batch.column(9);
/* 134 */       scan_colInstance10 = scan_batch.column(10);
/* 135 */       scan_colInstance11 = scan_batch.column(11);
/* 136 */       scan_colInstance12 = scan_batch.column(12);
/* 137 */       scan_colInstance13 = scan_batch.column(13);
/* 138 */       scan_colInstance14 = scan_batch.column(14);
/* 139 */       scan_colInstance15 = scan_batch.column(15);
/* 140 */       scan_colInstance16 = scan_batch.column(16);
/* 141 */       scan_colInstance17 = scan_batch.column(17);
/* 142 */       scan_colInstance18 = scan_batch.column(18);
/* 143 */       scan_colInstance19 = scan_batch.column(19);
/* 144 */       scan_colInstance20 = scan_batch.column(20);
/* 145 */       scan_colInstance21 = scan_batch.column(21);
/* 146 */       scan_colInstance22 = scan_batch.column(22);
/* 147 */       scan_colInstance23 = scan_batch.column(23);
/* 148 */       scan_colInstance24 = scan_batch.column(24);
/* 149 */       scan_colInstance25 = scan_batch.column(25);
/* 150 */       scan_colInstance26 = scan_batch.column(26);
/* 151 */       scan_colInstance27 = scan_batch.column(27);
/* 152 */       scan_colInstance28 = scan_batch.column(28);
/* 153 */
/* 154 */     }
/* 155 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 156 */   }
/* 157 */
/* 158 */   private void wholestagecodegen_init_2() {
/* 159 */     bhj_result = new UnsafeRow(1);
/* 160 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 161 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 1);
/* 162 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 163 */     bhj_result1 = new UnsafeRow(29);
/* 164 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 640);
/* 165 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 29);
/* 166 */     project_result1 = new UnsafeRow(3);
/* 167 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 168 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 169 */
/* 170 */   }
/* 171 */
/* 172 */   private void wholestagecodegen_init_1() {
/* 173 */     scan_result = new UnsafeRow(29);
/* 174 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 640);
/* 175 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 29);
/* 176 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 177 */     filter_result = new UnsafeRow(29);
/* 178 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 640);
/* 179 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 29);
/* 180 */     project_result = new UnsafeRow(29);
/* 181 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 640);
/* 182 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 29);
/* 183 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 184 */
/* 185 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 186 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 187 */
/* 188 */   }
/* 189 */
/* 190 */   protected void processNext() throws java.io.IOException {
/* 191 */     if (scan_batch == null) {
/* 192 */       scan_nextBatch();
/* 193 */     }
/* 194 */     while (scan_batch != null) {
/* 195 */       int numRows = scan_batch.numRows();
/* 196 */       while (scan_batchIdx < numRows) {
/* 197 */         int scan_rowIdx = scan_batchIdx++;
/* 198 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 199 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 200 */
/* 201 */         if (!(!(scan_isNull))) continue;
/* 202 */
/* 203 */         filter_numOutputRows.add(1);
/* 204 */
/* 205 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 206 */         UTF8String scan_value24 = scan_isNull24 ? null : (scan_colInstance24.getUTF8String(scan_rowIdx));
/* 207 */
/* 208 */         // generate join key for stream side
/* 209 */
/* 210 */         bhj_holder.reset();
/* 211 */
/* 212 */         bhj_rowWriter.zeroOutNullBytes();
/* 213 */
/* 214 */         if (scan_isNull24) {
/* 215 */           bhj_rowWriter.setNullAt(0);
/* 216 */         } else {
/* 217 */           bhj_rowWriter.write(0, scan_value24);
/* 218 */         }
/* 219 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 220 */
/* 221 */         // find matches from HashedRelation
/* 222 */         UnsafeRow bhj_matched = bhj_result.anyNull() ? null: (UnsafeRow)bhj_relation.getValue(bhj_result);
/* 223 */         if (bhj_matched == null) continue;
/* 224 */
/* 225 */         bhj_numOutputRows.add(1);
/* 226 */
/* 227 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 228 */         UTF8String scan_value23 = scan_isNull23 ? null : (scan_colInstance23.getUTF8String(scan_rowIdx));
/* 229 */         project_holder1.reset();
/* 230 */
/* 231 */         project_rowWriter1.zeroOutNullBytes();
/* 232 */
/* 233 */         project_rowWriter1.write(0, scan_value);
/* 234 */
/* 235 */         if (scan_isNull23) {
/* 236 */           project_rowWriter1.setNullAt(1);
/* 237 */         } else {
/* 238 */           project_rowWriter1.write(1, scan_value23);
/* 239 */         }
/* 240 */
/* 241 */         if (scan_isNull24) {
/* 242 */           project_rowWriter1.setNullAt(2);
/* 243 */         } else {
/* 244 */           project_rowWriter1.write(2, scan_value24);
/* 245 */         }
/* 246 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 247 */         append(project_result1);
/* 248 */         if (shouldStop()) return;
/* 249 */       }
/* 250 */       scan_batch = null;
/* 251 */       scan_nextBatch();
/* 252 */     }
/* 253 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 254 */     scan_scanTime1 = 0;
/* 255 */   }
/* 256 */ }
