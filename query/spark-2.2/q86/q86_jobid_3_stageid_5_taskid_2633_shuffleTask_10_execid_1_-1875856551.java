/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */   private int compare_1(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA2;
/* 022 */     int primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull7 = i.isNullAt(4);
/* 026 */       int value7 = isNull7 ? -1 : (i.getInt(4));
/* 027 */       isNullA2 = isNull7;
/* 028 */       primitiveA2 = value7;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB2;
/* 032 */     int primitiveB2;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull7 = i.isNullAt(4);
/* 036 */       int value7 = isNull7 ? -1 : (i.getInt(4));
/* 037 */       isNullB2 = isNull7;
/* 038 */       primitiveB2 = value7;
/* 039 */     }
/* 040 */     if (isNullA2 && isNullB2) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA2) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB2) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     return 0;
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */
/* 058 */   private int compare_0(InternalRow a, InternalRow b) {
/* 059 */
/* 060 */     InternalRow i = null;  // Holds current row being evaluated.
/* 061 */
/* 062 */     i = a;
/* 063 */     boolean isNullA;
/* 064 */     byte primitiveA;
/* 065 */     {
/* 066 */
/* 067 */       byte value = i.getByte(3);
/* 068 */       isNullA = false;
/* 069 */       primitiveA = value;
/* 070 */     }
/* 071 */     i = b;
/* 072 */     boolean isNullB;
/* 073 */     byte primitiveB;
/* 074 */     {
/* 075 */
/* 076 */       byte value = i.getByte(3);
/* 077 */       isNullB = false;
/* 078 */       primitiveB = value;
/* 079 */     }
/* 080 */     if (isNullA && isNullB) {
/* 081 */       // Nothing
/* 082 */     } else if (isNullA) {
/* 083 */       return 1;
/* 084 */     } else if (isNullB) {
/* 085 */       return -1;
/* 086 */     } else {
/* 087 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 088 */       if (comp != 0) {
/* 089 */         return -comp;
/* 090 */       }
/* 091 */     }
/* 092 */
/* 093 */     i = a;
/* 094 */     boolean isNullA1;
/* 095 */     UTF8String primitiveA1;
/* 096 */     {
/* 097 */
/* 098 */       boolean isNull1 = true;
/* 099 */       UTF8String value1 = null;
/* 100 */
/* 101 */
/* 102 */       boolean isNull2 = false;
/* 103 */
/* 104 */       byte value4 = i.getByte(3);
/* 105 */       boolean isNull3 = false;
/* 106 */       int value3 = -1;
/* 107 */       if (!false) {
/* 108 */         value3 = (int) value4;
/* 109 */       }
/* 110 */
/* 111 */       boolean value2 = false;
/* 112 */       value2 = value3 == 0;
/* 113 */       if (!false && value2) {
/* 114 */
/* 115 */         boolean isNull6 = i.isNullAt(1);
/* 116 */         UTF8String value6 = isNull6 ? null : (i.getUTF8String(1));
/* 117 */         isNull1 = isNull6;
/* 118 */         value1 = value6;
/* 119 */       }
/* 120 */
/* 121 */       else {
/* 122 */       }
/* 123 */       isNullA1 = isNull1;
/* 124 */       primitiveA1 = value1;
/* 125 */     }
/* 126 */     i = b;
/* 127 */     boolean isNullB1;
/* 128 */     UTF8String primitiveB1;
/* 129 */     {
/* 130 */
/* 131 */       boolean isNull1 = true;
/* 132 */       UTF8String value1 = null;
/* 133 */
/* 134 */
/* 135 */       boolean isNull2 = false;
/* 136 */
/* 137 */       byte value4 = i.getByte(3);
/* 138 */       boolean isNull3 = false;
/* 139 */       int value3 = -1;
/* 140 */       if (!false) {
/* 141 */         value3 = (int) value4;
/* 142 */       }
/* 143 */
/* 144 */       boolean value2 = false;
/* 145 */       value2 = value3 == 0;
/* 146 */       if (!false && value2) {
/* 147 */
/* 148 */         boolean isNull6 = i.isNullAt(1);
/* 149 */         UTF8String value6 = isNull6 ? null : (i.getUTF8String(1));
/* 150 */         isNull1 = isNull6;
/* 151 */         value1 = value6;
/* 152 */       }
/* 153 */
/* 154 */       else {
/* 155 */       }
/* 156 */       isNullB1 = isNull1;
/* 157 */       primitiveB1 = value1;
/* 158 */     }
/* 159 */     if (isNullA1 && isNullB1) {
/* 160 */       // Nothing
/* 161 */     } else if (isNullA1) {
/* 162 */       return -1;
/* 163 */     } else if (isNullB1) {
/* 164 */       return 1;
/* 165 */     } else {
/* 166 */       int comp = primitiveA1.compare(primitiveB1);
/* 167 */       if (comp != 0) {
/* 168 */         return comp;
/* 169 */       }
/* 170 */     }
/* 171 */
/* 172 */     return 0;
/* 173 */
/* 174 */   }
/* 175 */
/* 176 */
/* 177 */   public int compare(InternalRow a, InternalRow b) {
/* 178 */
/* 179 */     InternalRow i = null;
/* 180 */
/* 181 */     int comp = compare_0(a, b);
/* 182 */     if (comp != 0) {
/* 183 */       return comp;
/* 184 */     }
/* 185 */
/* 186 */     int comp1 = compare_1(a, b);
/* 187 */     if (comp1 != 0) {
/* 188 */       return comp1;
/* 189 */     }
/* 190 */
/* 191 */
/* 192 */     return 0;
/* 193 */   }
/* 194 */ }
